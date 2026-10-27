package org.example.is_lab1.dtos;

import org.example.is_lab1.entities.Color;
import org.example.is_lab1.entities.Country;

import java.time.ZonedDateTime;

public class PersonDto {
    private Integer id;
    private Color eyeColor;
    private Color hairColor;
    private Integer idLocation;
    private String birthday;
    private Integer height;
    private String passportID;
    private Country nationality;

    public PersonDto() {}

    public PersonDto(Color eyeColor, Color hairColor, Integer idLocation, String birthday, Integer height, String passportID, Country nationality) {
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.idLocation = idLocation;
        this.birthday = birthday;
        this.height = height;
        this.passportID = passportID;
        this.nationality = nationality;
    }

    public PersonDto(Integer id, Color eyeColor, Color hairColor, Integer idLocation, String birthday, Integer height, String passportID, Country nationality) {
        this.id = id;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.idLocation = idLocation;
        this.birthday = birthday;
        this.height = height;
        this.passportID = passportID;
        this.nationality = nationality;
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

    public Integer getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(Integer idLocation) {
        this.idLocation = idLocation;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
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
