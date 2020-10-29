package com.cenfotec.assets.service;

import com.cenfotec.assets.model.AssetType;

import java.util.List;
import java.util.Optional;

public interface IAssetTypeService {
    public AssetType save(AssetType assetType);
    public AssetType update(AssetType assetType);
    public void delete(Long id);
    public List<AssetType> getAll();
    public Optional<AssetType> getById(Long id);
}
