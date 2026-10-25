package org.example.is_lab1.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.ZonedDateTime;

@Entity
@Table(name = "people")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Color eyeColor;

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private Color hairColor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @Column(nullable = false)
    private java.time.ZonedDateTime birthday;

    @Column(nullable = false)
    @Min(1)
    private Integer height;

    @Column(nullable = false)
    @NotBlank
    @Size(min = 8)
    private String passportID;

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private Country nationality;

    public Person() {}

    public Person(Integer id, Color eyeColor, Color hairColor, Location location, ZonedDateTime birthday, Integer height, String passportID, Country nationality) {
        this.id = id;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.location = location;
        this.birthday = birthday;
        this.height = height;
        this.passportID = passportID;
        this.nationality = nationality;
    }

    public Person(Color eyeColor, Color hairColor, Location location, ZonedDateTime birthday, Integer height, String passportID, Country nationality) {
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.location = location;
        this.birthday = birthday;
        this.height = height;
        this.passportID = passportID;
        this.nationality = nationality;
    }

    public Person(Integer id, Color eyeColor, Location location, ZonedDateTime birthday, Integer height, String passportID, Country nationality) {
        this.id = id;
        this.eyeColor = eyeColor;
        this.location = location;
        this.birthday = birthday;
        this.height = height;
        this.passportID = passportID;
        this.nationality = nationality;
    }

    public Person(Color eyeColor, Location location, ZonedDateTime birthday, Integer height, String passportID, Country nationality) {
        this.eyeColor = eyeColor;
        this.location = location;
        this.birthday = birthday;
        this.height = height;
        this.passportID = passportID;
        this.nationality = nationality;
    }

    public Person(Integer id, Color eyeColor, Color hairColor, Location location, ZonedDateTime birthday, Integer height, String passportID) {
        this.id = id;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.location = location;
        this.birthday = birthday;
        this.height = height;
        this.passportID = passportID;
    }

    public Person(Color eyeColor, Color hairColor, Location location, ZonedDateTime birthday, Integer height, String passportID) {
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.location = location;
        this.birthday = birthday;
        this.height = height;
        this.passportID = passportID;
    }

    public Person(Integer id, Color eyeColor, Location location, ZonedDateTime birthday, Integer height, String passportID) {
        this.id = id;
        this.eyeColor = eyeColor;
        this.location = location;
        this.birthday = birthday;
        this.height = height;
        this.passportID = passportID;
    }

    public Person(Color eyeColor, Location location, ZonedDateTime birthday, Integer height, String passportID) {
        this.eyeColor = eyeColor;
        this.location = location;
        this.birthday = birthday;
        this.height = height;
        this.passportID = passportID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Color getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(Color eyeColor) {
        this.eyeColor = eyeColor;
    }

    public Color getHairColor() {
        return hairColor;
    }

    public void setHairColor(Color hairColor) {
        this.hairColor = hairColor;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public ZonedDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(ZonedDateTime birthday) {
        this.birthday = birthday;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getPassportID() {
        return passportID;
    }

    public void setPassportID(String passportID) {
        this.passportID = passportID;
    }

    public Country getNationality() {
        return nationality;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }
}
