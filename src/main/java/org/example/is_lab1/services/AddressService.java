package org.example.is_lab1.services;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.example.is_lab1.daos.AddressDao;
import org.example.is_lab1.daos.LocationDao;
import org.example.is_lab1.dtos.AddressDto;
import org.example.is_lab1.entities.Address;
import org.example.is_lab1.entities.Location;
import org.example.is_lab1.exceptions.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
@Transactional
public class AddressService {

    @Inject
    private AddressDao addressDao;

    @Inject
    private LocationDao locationDao;

    public List<AddressDto> findAll() {
        return addressDao.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public AddressDto create(AddressDto dto) {
        Address address = new Address();
        address.setStreet(dto.getStreet());

        if (dto.getTownId() != null) {
            Location town = locationDao.findById(dto.getTownId())
                    .orElseThrow(() -> new NotFoundException("location с id " + dto.getTownId() + " не найдена"));
            address.setTown(town);
        } else {
            address.setTown(null);
        }

        Address saved = addressDao.create(address);
        return convertToDto(saved);
    }

    private AddressDto convertToDto(Address address) {
        AddressDto dto = new AddressDto();
        dto.setId(address.getId());
        dto.setStreet(address.getStreet());

        if (address.getTown() != null) {
            dto.setTownId(address.getTown().getId());
        }
        return dto;
    }
}