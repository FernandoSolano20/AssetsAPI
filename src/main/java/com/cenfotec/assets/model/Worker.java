package com.cenfotec.assets.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "workers")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String lastName;

    private LocalDate birthday;

    private int state;

    @JsonIgnore
    @OneToMany(mappedBy = "worker")
    private Set<AssignAssetsWorkers> assignAssetsWorkers = new HashSet<>();

    public Worker() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Set<AssignAssetsWorkers> getAssignAssetsWorkers() {
        return assignAssetsWorkers;
    }

    public void setAssignAssetsWorkers(Set<AssignAssetsWorkers> assignAssetsWorkers) {
        this.assignAssetsWorkers = assignAssetsWorkers;
    }
}
