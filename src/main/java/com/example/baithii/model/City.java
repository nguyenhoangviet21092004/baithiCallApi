package com.example.baithii.model;

import jakarta.persistence.*;

@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id ;

    private String name ;
    private String nation ;
    private int acreage;
    private int population;
    private int gdp;
    private String description;


    @ManyToOne
    @JoinColumn(name = "idNation")
    private Nation nameNation;

    public City(int id, String name, String nation, int acreage, int population, int gdp, String description, Nation nameNation) {
        this.id = id;
        this.name = name;
        this.nation = nation;
        this.acreage = acreage;
        this.population = population;
        this.gdp = gdp;
        this.description = description;
        this.nameNation = nameNation;
    }

    public Nation getNameNation() {
        return nameNation;
    }

    public void setNameNation(Nation nameNation) {
        this.nameNation = nameNation;
    }

    public City() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public int getAcreage() {
        return acreage;
    }

    public void setAcreage(int acreage) {
        this.acreage = acreage;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getGdp() {
        return gdp;
    }

    public void setGdp(int gdp) {
        this.gdp = gdp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
