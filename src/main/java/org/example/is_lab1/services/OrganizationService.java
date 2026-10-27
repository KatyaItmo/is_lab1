package org.example.is_lab1.services;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.example.is_lab1.daos.AddressDao;
import org.example.is_lab1.daos.OrganizationDao;
import org.example.is_lab1.dtos.OrganizationDto;
import org.example.is_lab1.entities.Address;
import org.example.is_lab1.entities.Organization;
import org.example.is_lab1.exceptions.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
@Transactional
public class OrganizationService {

    @Inject
    private OrganizationDao organizationDao;

    @Inject
    private AddressDao addressDao;

    public List<OrganizationDto> findAll() {
        return organizationDao.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public OrganizationDto create(OrganizationDto dto) {
        Organization org = new Organization();
        org.setAnnualTurnover(dto.getAnnualTurnover());
        org.setEmployeesCount(dto.getEmployeesCount());
        org.setRating(dto.getRating());
        org.setType(dto.getType());

        // officialAddress может быть null по модели
        if (dto.getIdOfficialAddress() != null) {
            Address official = addressDao.findById(dto.getIdOfficialAddress())
                    .orElseThrow(() -> new NotFoundException("official address с id " + dto.getIdOfficialAddress() + " не найден"));
            org.setOfficialAddress(official);
        } else {
            org.setOfficialAddress(null);
        }

        // postalAddress не может быть null по модели
        if (dto.getIdPostalAddress() != null) {
            Address postal = addressDao.findById(dto.getIdPostalAddress())
                    .orElseThrow(() -> new NotFoundException("postal Address с id " + dto.getIdPostalAddress() + " не найден"));
            org.setPostalAddress(postal);
        } else {
            throw new IllegalArgumentException("поле postalAddressId обязательно для организации");
        }

        Organization saved = organizationDao.create(org);
        return convertToDto(saved);
    }

    private OrganizationDto convertToDto(Organization org) {
        OrganizationDto dto = new OrganizationDto();
        dto.setId(org.getId());
        dto.setAnnualTurnover(org.getAnnualTurnover());
        dto.setEmployeesCount(org.getEmployeesCount());
        dto.setRating(org.getRating());
        dto.setType(org.getType());

        if (org.getOfficialAddress() != null) {
            dto.setIdOfficialAddress(org.getOfficialAddress().getId());
        }
        if (org.getPostalAddress() != null) {
            dto.setIdPostalAddress(org.getPostalAddress().getId());
        }

        return dto;
    }
}