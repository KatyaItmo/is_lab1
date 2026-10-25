package org.example.is_lab1.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "coordinates")
public class Coordinates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Double x;

    @Column(nullable = false)
    private int y;

    public Coordinates() {}

    public Coordinates(Integer id, Double x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public Coordinates(Double x, int y) {
        this.x = x;
        this.y = y;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
