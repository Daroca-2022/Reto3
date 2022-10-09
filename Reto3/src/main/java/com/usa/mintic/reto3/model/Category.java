package com.usa.mintic.reto3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
<<<<<<< HEAD
import net.minidev.json.annotate.JsonIgnore;
=======
>>>>>>> nicolas

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "category")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
    private Integer id;
   // @Column(name = "name",nullable = true, length = 45)
    private String name;
   // @Column(name = "description", nullable = true, length = 250)
    private String description;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "category")
    @JsonIgnoreProperties("category")
    private List<Machine> machines;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
=======
    private Integer idCategory;
    private String name;
    private String description;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "category")
    @JsonIgnoreProperties("category")
    private List<Machine> machines;

    public Integer getIdCategory() {
        return idCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIdCategory(Integer id) {
        this.idCategory = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Machine> getMachines() {
        return machines;
    }

    public void setMachines(List<Machine> machines) {
        this.machines = machines;
>>>>>>> nicolas
    }
}
