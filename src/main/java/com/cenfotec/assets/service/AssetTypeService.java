package com.cenfotec.assets.service;

import com.cenfotec.assets.model.AssetType;
import com.cenfotec.assets.repository.AssetTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssetTypeService implements IAssetTypeService {
    @Autowired
    AssetTypeRepository repository;

    @Override
    public AssetType save(AssetType assetType) {
        return repository.save(assetType);
    }

    @Override
    public AssetType update(AssetType assetType) {
        return repository.save(assetType);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<AssetType> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<AssetType> getById(Long id) {
        return repository.findById(id);
    }
}
