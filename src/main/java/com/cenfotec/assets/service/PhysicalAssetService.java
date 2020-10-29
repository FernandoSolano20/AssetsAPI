package com.cenfotec.assets.service;

import com.cenfotec.assets.model.AssetType;
import com.cenfotec.assets.model.PhysicalAsset;
import com.cenfotec.assets.repository.AssetTypeRepository;
import com.cenfotec.assets.repository.PhysicalAssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhysicalAssetService implements IPhysicalAssetService {
    @Autowired
    PhysicalAssetRepository repository;
    @Autowired
    AssetTypeRepository assetTypeRepository;

    @Override
    public PhysicalAsset save(PhysicalAsset physicalAsset) {
        AssetType assetType = physicalAsset.getAssetId();
        AssetType currentAssetTypeInfo = assetTypeRepository.findById(assetType.getId()).get();
        if (currentAssetTypeInfo == null || currentAssetTypeInfo.getState() == 0) {
            return null;
        }
        return repository.save(physicalAsset);
    }

    @Override
    public PhysicalAsset update(PhysicalAsset physicalAsset) {
        return save(physicalAsset);
    }

    @Override
    public PhysicalAsset assignWorkerToAsset(PhysicalAsset physicalAsset) {
        PhysicalAsset currentEntity = getById(physicalAsset.getId()).get();
        if (currentEntity == null
                || currentEntity.getState() == 0
                || currentEntity.getAssignedAssets() == currentEntity.getQuantity()){
            return null;
        }

        currentEntity.setAssignedAssets(currentEntity.getAssignedAssets() + 1);
        currentEntity.setWorkersId(physicalAsset.getWorkersId());
        currentEntity.setAssignedDate(physicalAsset.getAssignedDate());
        return repository.save(currentEntity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<PhysicalAsset> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<PhysicalAsset> getById(Long id) {
        return repository.findById(id);
    }
}
