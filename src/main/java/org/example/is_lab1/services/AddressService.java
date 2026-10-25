package org.example.is_lab1.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.example.is_lab1.daos.AddressDao;
import org.example.is_lab1.entities.Address;
import org.example.is_lab1.exceptions.NotFoundException;

import java.util.List;

@Stateless
public class AddressService {

    @Inject
    private AddressDao addressDao;

    public List<Address> findAll() {
        return addressDao.findAll();
    }

    public Address findById(Integer id) {
        return addressDao.findById(id)
                .orElseThrow(() -> new NotFoundException("address с id " + id + " не найден"));
    }

    public Address create(Address address) {
        return addressDao.create(address);
    }
}
