package org.example.is_lab1.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NotBlank
    private String street;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "town_id", nullable = true)
    private Location town;

    public Address() {}

    public Address(Integer id, String street, Location town) {
        this.id = id;
        this.street = street;
        this.town = town;
    }

    public Address(String street, Location town) {
        this.street = street;
        this.town = town;
    }

    public Address(Integer id, String street) {
        this.id = id;
        this.street = street;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Address(String street) {
        this.street = street;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Location getTown() {
        return town;
    }

    public void setTown(Location town) {
        this.town = town;
    }
}
