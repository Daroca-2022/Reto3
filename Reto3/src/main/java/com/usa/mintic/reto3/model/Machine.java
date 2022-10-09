package com.usa.mintic.reto3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "machine")

public class Machine implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String brand;
    private String name;
    private Integer yearMachine;

    private String description;


    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("machines")

    //Messages Reservation



    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
>>>>>>> nicolas

    public Integer getId() {
        return id;
    }

<<<<<<< HEAD
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
=======
    public void setId(Integer id) {
        this.id = id;
>>>>>>> nicolas
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

<<<<<<< HEAD
    public Integer getYearMachine() {
        return yearMachine;
    }

    public void setYearMachine(Integer yearMachine) {
        this.yearMachine = yearMachine;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

=======
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
>>>>>>> nicolas
