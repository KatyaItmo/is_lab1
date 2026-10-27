package org.example.is_lab1.dtos;

import org.example.is_lab1.entities.OrganizationType;

public class OrganizationDto {
    private Integer id;
    private Integer idOfficialAddress;
    private long annualTurnover;
    private Integer employeesCount;
    private Long rating;
    private OrganizationType type;
    private Integer idPostalAddress;

    public OrganizationDto() {}

    public OrganizationDto(Integer idOfficialAddress, long annualTurnover, Integer employeesCount, Long rating, OrganizationType type, Integer idPostalAddress) {
        this.idOfficialAddress = idOfficialAddress;
        this.annualTurnover = annualTurnover;
        this.employeesCount = employeesCount;
        this.rating = rating;
        this.type = type;
        this.idPostalAddress = idPostalAddress;
    }

    public OrganizationDto(Integer id, Integer idOfficialAddress, long annualTurnover, Integer employeesCount, Long rating, OrganizationType type, Integer idPostalAddress) {
        this.id = id;
        this.idOfficialAddress = idOfficialAddress;
        this.annualTurnover = annualTurnover;
        this.employeesCount = employeesCount;
        this.rating = rating;
        this.type = type;
        this.idPostalAddress = idPostalAddress;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdOfficialAddress() {
        return idOfficialAddress;
    }

    public void setIdOfficialAddress(Integer idOfficialAddress) {
        this.idOfficialAddress = idOfficialAddress;
    }

    public long getAnnualTurnover() {
        return annualTurnover;
    }

    public void setAnnualTurnover(long annualTurnover) {
        this.annualTurnover = annualTurnover;
    }

    public Integer getEmployeesCount() {
        return employeesCount;
    }

    public void setEmployeesCount(Integer employeesCount) {
        this.employeesCount = employeesCount;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    public OrganizationType getType() {
        return type;
    }

    public void setType(OrganizationType type) {
        this.type = type;
    }

    public Integer getIdPostalAddress() {
        return idPostalAddress;
    }

    public void setIdPostalAddress(Integer idPostalAddress) {
        this.idPostalAddress = idPostalAddress;
    }
}
