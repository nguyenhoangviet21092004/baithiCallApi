package com.example.baithii.model;

import jakarta.persistence.*;

@Entity
@Table(name = "nation")
public class Nation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameNation;

    public Nation(int id, String nameNation) {
        this.id = id;
        this.nameNation = nameNation;

    }

    public Nation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameNation() {
        return nameNation;
    }

    public void setNameNation(String nameNation) {
        this.nameNation = nameNation;
    }
}
