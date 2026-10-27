package org.example.is_lab1.dtos;

public class AddressDto {
    private Integer id;
    private String street;
    private Integer townId;

    public AddressDto() {}

    public AddressDto(String street, Integer townId) {
        this.street = street;
        this.townId = townId;
    }

    public AddressDto(Integer id, String street, Integer locationId) {
        this.id = id;
        this.street = street;
        this.townId = locationId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getTownId() {
        return townId;
    }

    public void setTownId(Integer locationId) {
        this.townId = locationId;
    }
}
