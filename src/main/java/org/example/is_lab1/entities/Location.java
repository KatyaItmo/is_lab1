package org.example.is_lab1.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Long x;

    @Column(nullable = false)
    private Integer y;

    @Column(nullable = false)
    private Integer z;

    public Location() {}

    public Location(Integer id, Long x, Integer y, Integer z) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Location(Long x, Integer y, Integer z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getX() {
        return x;
    }

    public void setX(Long x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getZ() {
        return z;
    }

    public void setZ(Integer z) {
        this.z = z;
    }
}
