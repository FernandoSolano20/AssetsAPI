package com.cenfotec.assets.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "physical_asset")
public class PhysicalAsset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String year;

    private int quantity;

    private int assignedAssets;

    private int state;

    @ManyToOne()
    @JoinColumn(name = "asset_id")
    private AssetType assetId;

    @OneToMany(mappedBy = "physicalAsset", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<AssignAssetsWorkers> assignAssetsWorkers  = new HashSet<>();

    public PhysicalAsset() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getAssignedAssets() {
        return assignedAssets;
    }

    public void setAssignedAssets(int assignedAssets) {
        this.assignedAssets = assignedAssets;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public AssetType getAssetId() {
        return assetId;
    }

    public void setAssetId(AssetType assetId) {
        this.assetId = assetId;
    }

    public Set<AssignAssetsWorkers> getAssignAssetsWorkers() {
        return assignAssetsWorkers;
    }

    public void setAssignAssetsWorkers(Set<AssignAssetsWorkers> assignAssetsWorkers) {
        this.assignAssetsWorkers = assignAssetsWorkers;
    }
}
