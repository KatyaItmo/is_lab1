package org.example.is_lab1.daos;

import jakarta.ejb.Stateless;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.is_lab1.entities.Address;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class AddressDao {

    @PersistenceContext(unitName = "MyPU")
    private EntityManager em;

    public Address create(Address address) {
        em.persist(address);
        return address;
    }

    public Optional<Address> findById(Integer id) {
        Address address = em.find(Address.class, id);
        return Optional.ofNullable(address);
    }

    public List<Address> findAll() {
        return em.createQuery("SELECT a FROM Address a", Address.class).getResultList();
    }
}
