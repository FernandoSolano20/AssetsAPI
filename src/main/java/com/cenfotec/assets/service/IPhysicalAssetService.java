package com.cenfotec.assets.service;

import com.cenfotec.assets.model.AssignAssetsWorkers;
import com.cenfotec.assets.model.PhysicalAsset;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IPhysicalAssetService {
    public PhysicalAsset save(PhysicalAsset physicalAsset) throws Exception;
    public PhysicalAsset update(PhysicalAsset physicalAsset) throws Exception;
    public PhysicalAsset assignWorkerToAsset(AssignAssetsWorkers assignAssetsWorkers) throws Exception;
    public void delete(Long id);
    public List<PhysicalAsset> getAll();
    public Optional<PhysicalAsset> getById(Long id);
}
