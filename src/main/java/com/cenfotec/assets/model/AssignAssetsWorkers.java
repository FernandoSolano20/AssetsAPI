package com.cenfotec.assets.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "assign_assets_workers")
public class AssignAssetsWorkers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "workers_id")
    Worker worker;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "physical_asset_id")
    PhysicalAsset physicalAsset;

    LocalDate date;

    public AssignAssetsWorkers() {
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public PhysicalAsset getPhysicalAsset() {
        return physicalAsset;
    }

    public void setPhysicalAsset(PhysicalAsset physicalAsset) {
        this.physicalAsset = physicalAsset;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
