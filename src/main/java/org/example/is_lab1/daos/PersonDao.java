package org.example.is_lab1.daos;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.is_lab1.entities.Person;

import java.util.List;
import java.util.Optional;

@Stateless
public class PersonDao {
    @PersistenceContext
    private EntityManager em;

    public Person create(Person person) {
        em.persist(person);
        return person;
    }

    public Optional<Person> findById(Integer id) {
        Person person = em.find(Person.class, id);
        return Optional.ofNullable(person);
    }

    public List<Person> findAll() {
        return em.createQuery("SELECT p FROM Person p", Person.class).getResultList();
    }
}
