package com.cenfotec.assets.controllers;

import com.cenfotec.assets.model.AssetType;
import com.cenfotec.assets.service.IAssetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"api/assettypes"})
@CrossOrigin
public class AssetTypeController {
    @Autowired
    private IAssetTypeService service;

    @GetMapping
    public List findAll()
    {
        return service.getAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<AssetType> findById(@PathVariable Long id)
    {
        return service.getById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public AssetType create(@RequestBody AssetType assetType)
    {
        return service.save(assetType);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<AssetType> update(@PathVariable("id") Long id, @RequestBody AssetType assetType)
    {
        return service.getById(id)
                .map(record -> {
                    record.setName(assetType.getName());
                    record.setDescription(assetType.getDescription());
                    record.setState(assetType.getState());
                    AssetType updated = service.update(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity<?> delete(@PathVariable("id") Long id)
    {
        return service.getById(id)
                .map(record -> {
                    service.delete(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
