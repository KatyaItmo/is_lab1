package org.example.is_lab1.daos;

import jakarta.ejb.Stateless;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.is_lab1.entities.Organization;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class OrganizationDao {

    @PersistenceContext(unitName = "MyPU")
    private EntityManager em;

    public Organization create(Organization organization) {
        em.persist(organization);
        return organization;
    }

    public Optional<Organization> findById(Integer id) {
        Organization organization = em.find(Organization.class, id);
        return Optional.ofNullable(organization);
    }

    public List<Organization> findAll() {
        return em.createQuery("SELECT o FROM Organization o", Organization.class).getResultList();
    }
}
