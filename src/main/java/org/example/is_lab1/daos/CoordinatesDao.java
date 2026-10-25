package org.example.is_lab1.daos;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.is_lab1.entities.Coordinates;

import java.util.List;
import java.util.Optional;

@Stateless
public class CoordinatesDao {

    @PersistenceContext
    private EntityManager em;

    public Coordinates create(Coordinates coordinates) {
        em.persist(coordinates);
        return coordinates;
    }

    public Optional<Coordinates> findById(Integer id) {
        Coordinates coordinates = em.find(Coordinates.class, id);
        return Optional.ofNullable(coordinates);
    }

    public List<Coordinates> findAll() {
        return em.createQuery("SELECT c FROM Coordinates c", Coordinates.class).getResultList();
    }
}
