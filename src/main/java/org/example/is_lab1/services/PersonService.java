package org.example.is_lab1.services;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.example.is_lab1.daos.LocationDao;
import org.example.is_lab1.daos.PersonDao;
import org.example.is_lab1.dtos.PersonDto;
import org.example.is_lab1.entities.Location;
import org.example.is_lab1.entities.Person;
import org.example.is_lab1.exceptions.NotFoundException;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
@Transactional
public class PersonService {

    @Inject
    private PersonDao personDao;

    @Inject
    private LocationDao locationDao;

    public List<PersonDto> findAll() {
        return personDao.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public PersonDto create(PersonDto dto) {
        Person person = new Person();
        person.setEyeColor(dto.getEyeColor());
        person.setHairColor(dto.getHairColor());
        person.setHeight(dto.getHeight());
        person.setPassportID(dto.getPassportID());
        person.setNationality(dto.getNationality());

        if (dto.getBirthday() != null && !dto.getBirthday().isBlank()) {
            person.setBirthday(ZonedDateTime.parse(dto.getBirthday()));
        } else {
            throw new IllegalArgumentException("поле birthday обязательно для Person");
        }

        if (dto.getIdLocation() != null) {
            Location location = locationDao.findById(dto.getIdLocation())
                    .orElseThrow(() -> new NotFoundException("location с id " + dto.getIdLocation() + " не найдена"));
            person.setLocation(location);
        } else {
            throw new IllegalArgumentException("поле idLocation обязательно для Person");
        }

        Person saved = personDao.create(person);
        return convertToDto(saved);
    }

    private PersonDto convertToDto(Person person) {
        PersonDto dto = new PersonDto();
        dto.setId(person.getId());
        dto.setEyeColor(person.getEyeColor());
        dto.setHairColor(person.getHairColor());
        dto.setHeight(person.getHeight());
        dto.setPassportID(person.getPassportID());
        dto.setNationality(person.getNationality());

        if (person.getBirthday() != null) {
            dto.setBirthday(person.getBirthday().toString());
        }

        if (person.getLocation() != null) {
            dto.setIdLocation(person.getLocation().getId());
        }

        return dto;
    }
}