package com.cenfotec.assets.service;

import com.cenfotec.assets.model.PhysicalAsset;

import java.util.List;
import java.util.Optional;

public interface IPhysicalAssetService {
    public PhysicalAsset save(PhysicalAsset physicalAsset);
    public PhysicalAsset update(PhysicalAsset physicalAsset);
    public PhysicalAsset assignWorkerToAsset(PhysicalAsset physicalAsset);
    public void delete(Long id);
    public List<PhysicalAsset> getAll();
    public Optional<PhysicalAsset> getById(Long id);
}
