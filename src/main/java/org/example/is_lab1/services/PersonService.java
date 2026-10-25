package org.example.is_lab1.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.example.is_lab1.daos.PersonDao;
import org.example.is_lab1.entities.Person;
import org.example.is_lab1.exceptions.NotFoundException;

import java.util.List;

@Stateless
public class PersonService {

    @Inject
    private PersonDao personDao;

    public List<Person> findAll() {
        return personDao.findAll();
    }

    public Person findById(Integer id) {
        return personDao.findById(id)
                .orElseThrow(() -> new NotFoundException("person с id " + id + " не найден"));
    }

    public Person create(Person person) {
        return personDao.create(person);
    }
}
