package org.example.is_lab1.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "organizations")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "officialAddress_id", nullable = true)
    private Address officialAddress;

    @Column(nullable = false)
    @Min(1)
    private long annualTurnover;

    @Column(nullable = true)
    @Min(1)
    private Integer employeesCount;

    @Column(nullable = false)
    @Min(1)
    private Long rating;

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private OrganizationType type;

    @ManyToOne
    @JoinColumn(name = "postalAddress_id", nullable = false)
    @NotNull
    private Address postalAddress;

    public Organization() {}

    public Organization(Integer id, Address officialAddress, long annualTurnover, Integer employeesCount, Long rating, OrganizationType type, Address postalAddress) {
        this.id = id;
        this.officialAddress = officialAddress;
        this.annualTurnover = annualTurnover;
        this.employeesCount = employeesCount;
        this.rating = rating;
        this.type = type;
        this.postalAddress = postalAddress;
    }

    public Organization(Address officialAddress, long annualTurnover, Integer employeesCount, Long rating, OrganizationType type, Address postalAddress) {
        this.officialAddress = officialAddress;
        this.annualTurnover = annualTurnover;
        this.employeesCount = employeesCount;
        this.rating = rating;
        this.type = type;
        this.postalAddress = postalAddress;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Address getOfficialAddress() {
        return officialAddress;
    }

    public void setOfficialAddress(Address officialAddress) {
        this.officialAddress = officialAddress;
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

    public Address getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(Address postalAddress) {
        this.postalAddress = postalAddress;
    }
}
