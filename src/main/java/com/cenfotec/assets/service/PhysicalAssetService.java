package com.cenfotec.assets.service;

import com.cenfotec.assets.model.AssetType;
import com.cenfotec.assets.model.AssignAssetsWorkers;
import com.cenfotec.assets.model.PhysicalAsset;
import com.cenfotec.assets.model.Worker;
import com.cenfotec.assets.repository.AssetTypeRepository;
import com.cenfotec.assets.repository.PhysicalAssetRepository;
import com.cenfotec.assets.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PhysicalAssetService implements IPhysicalAssetService {
    @Autowired
    PhysicalAssetRepository repository;
    @Autowired
    AssetTypeRepository assetTypeRepository;
    @Autowired
    WorkerRepository workerRepository;

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
    public PhysicalAsset assignWorkerToAsset(AssignAssetsWorkers assignAssetsWorkers) {
        PhysicalAsset currentEntity = getById(assignAssetsWorkers.getPhysicalAsset().getId()).get();
        if (currentEntity == null
                || currentEntity.getState() == 0
                || currentEntity.getAssignedAssets() == currentEntity.getQuantity()){
            return null;
        }
        Worker worker = workerRepository.findById(assignAssetsWorkers.getWorker().getId()).get();
        if(worker.getState() == 0){
            return null;
        }

        currentEntity.setAssignedAssets(currentEntity.getAssignedAssets() + 1);
        assignAssetsWorkers.setWorker(worker);
        assignAssetsWorkers.setPhysicalAsset(currentEntity);
        currentEntity.getAssignAssetsWorkers().add(assignAssetsWorkers);
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
