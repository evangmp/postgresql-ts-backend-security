package com.example.jenpeupu.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="test_table")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Boolean active;
    private String discipline;
    private String date;


    public Task() {
    }
    public Task(String name, String discipline, Boolean active, String date) {
        this.name = name;
        this.active = active;
        this.date = date;
        this.discipline = discipline;
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


    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getDiscipline() {
        return discipline;
    }
    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }
}
