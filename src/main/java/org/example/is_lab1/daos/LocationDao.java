package org.example.is_lab1.daos;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.is_lab1.entities.Location;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
@Transactional
public class LocationDao {

    @PersistenceContext(unitName = "MyPU")
    private EntityManager em;

    public Location create(Location location) {
        em.persist(location);
        return location;
    }

    public Optional<Location> findById(Integer id) {
        Location location = em.find(Location.class, id);
        return Optional.ofNullable(location);
    }

    public List<Location> findAll() {
        return em.createQuery("SELECT l FROM Location l", Location.class).getResultList();
    }
}