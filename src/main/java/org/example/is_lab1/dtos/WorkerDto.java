package org.example.is_lab1.dtos;

import org.example.is_lab1.entities.Position;
import org.example.is_lab1.entities.Status;

public class WorkerDto {
    private Integer id;
    private String name;
    private Integer idCoordinates;
    private String creationDate;
    private Integer idOrganization;
    private int salary;
    private float rating;
    private String startDate;
    private Position position;
    private Status status;
    private Integer idPerson;

    public WorkerDto() {}

    public WorkerDto(String name, Integer idCoordinates, Integer idOrganization, int salary, float rating, String startDate, Position position, Status status, Integer idPerson) {
        this.name = name;
        this.idCoordinates = idCoordinates;
        this.idOrganization = idOrganization;
        this.salary = salary;
        this.rating = rating;
        this.startDate = startDate;
        this.position = position;
        this.status = status;
        this.idPerson = idPerson;
    }

    public WorkerDto(Integer id, String name, Integer idCoordinates, String creationDate, Integer idOrganization, int salary, float rating, String startDate, Position position, Status status, Integer idPerson) {
        this.id = id;
        this.name = name;
        this.idCoordinates = idCoordinates;
        this.creationDate = creationDate;
        this.idOrganization = idOrganization;
        this.salary = salary;
        this.rating = rating;
        this.startDate = startDate;
        this.position = position;
        this.status = status;
        this.idPerson = idPerson;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIdCoordinates() {
        return idCoordinates;
    }

    public void setIdCoordinates(Integer idCoordinates) {
        this.idCoordinates = idCoordinates;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getIdOrganization() {
        return idOrganization;
    }

    public void setIdOrganization(Integer idOrganization) {
        this.idOrganization = idOrganization;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
    }
}
