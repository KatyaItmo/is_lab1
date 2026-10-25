package org.example.is_lab1.daos;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.is_lab1.entities.Worker;

import java.util.List;
import java.util.Optional;

@Stateless
public class WorkerDao {

    @PersistenceContext
    private EntityManager em;

    public Worker create(Worker worker) {
        em.persist(worker);
        return worker;
    }

    public Optional<Worker> findById(Integer id) {
        Worker worker = em.find(Worker.class, id);
        return Optional.ofNullable(worker);
    }

    public List<Worker> findAll() {
        return em.createQuery("SELECT w FROM Worker w", Worker.class).getResultList();
    }
}
