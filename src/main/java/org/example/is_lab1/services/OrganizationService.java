package org.example.is_lab1.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.example.is_lab1.daos.OrganizationDao;
import org.example.is_lab1.entities.Organization;
import org.example.is_lab1.exceptions.NotFoundException;

import java.util.List;

@Stateless
public class OrganizationService {

    @Inject
    private OrganizationDao organizationDao;

    public List<Organization> findAll() {
        return organizationDao.findAll();
    }

    public Organization findById(Integer id) {
        return organizationDao.findById(id)
                .orElseThrow(() -> new NotFoundException("organization с id " + id + " не найдена"));
    }

    public Organization create(Organization organization) {
        return organizationDao.create(organization);
    }
}
