package org.example.is_lab1.daos;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.is_lab1.entities.Status;
import org.example.is_lab1.entities.Worker;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class WorkerDao {

    @PersistenceContext(unitName = "MyPU")
    private EntityManager em;

    public Worker create(Worker worker) {
        em.persist(worker);
        return worker;
    }

    public Worker update(Worker worker) {
        return em.merge(worker);
    }

    public Optional<Worker> findById(Integer id) {
        return Optional.ofNullable(em.find(Worker.class, id));
    }

    public List<Worker> findAll() {
        return em.createQuery("SELECT w FROM Worker w", Worker.class).getResultList();
    }

    public void delete(Worker worker) {
        if (!em.contains(worker)) {
            worker = em.merge(worker);
        }
        em.remove(worker);
    }

    public List<Worker> findFilteredAndSorted(String nameFilter, String sortDirection) {
        String jpql = "SELECT w FROM Worker w";

        if (nameFilter != null && !nameFilter.isBlank()) {
            jpql += " WHERE LOWER(w.name) LIKE LOWER(:namePattern)";
        }

        if ("desc".equalsIgnoreCase(sortDirection)) {
            jpql += " ORDER BY w.name DESC";
        } else {
            jpql += " ORDER BY w.name ASC";
        }

        var query = em.createQuery(jpql, Worker.class);

        if (nameFilter != null && !nameFilter.isBlank()) {
            query.setParameter("namePattern", "%" + nameFilter + "%");
        }

        return query.getResultList();
    }

    public Double getAverageRating() {
        Double avg = em.createQuery("SELECT AVG(w.rating) FROM Worker w", Double.class).getSingleResult();
        return avg != null ? avg : 0.0;
    }

    public Long countByStatusLessThan(Status targetStatus) {
        return em.createQuery("SELECT COUNT(w) FROM Worker w WHERE w.status < :targetStatus", Long.class)
                .setParameter("targetStatus", targetStatus)
                .getSingleResult();
    }

    public List<Status> getUniqueStatuses() {
        return em.createQuery("SELECT DISTINCT w.status FROM Worker w", Status.class).getResultList();
    }
}