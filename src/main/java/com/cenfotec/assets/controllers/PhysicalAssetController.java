package com.cenfotec.assets.controllers;

import com.cenfotec.assets.model.AssignAssetsWorkers;
import com.cenfotec.assets.model.PhysicalAsset;
import com.cenfotec.assets.service.IPhysicalAssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"api/physicalassets"})
@CrossOrigin
public class PhysicalAssetController {
    @Autowired
    private IPhysicalAssetService service;

    @GetMapping
    public List findAll()
    {
        return service.getAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<PhysicalAsset> findById(@PathVariable Long id)
    {
        return service.getById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public PhysicalAsset create(@RequestBody PhysicalAsset physicalAsset) throws Exception {
        return service.save(physicalAsset);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<PhysicalAsset> update(@PathVariable("id") Long id, @RequestBody PhysicalAsset physicalAsset)
    {
        return service.getById(id)
                .map(record -> {
                    record.setName(physicalAsset.getName());
                    record.setDescription(physicalAsset.getDescription());
                    record.setYear(physicalAsset.getYear());
                    record.setQuantity(physicalAsset.getQuantity());
                    record.setState(physicalAsset.getState());
                    record.setAssetId(physicalAsset.getAssetId());
                    PhysicalAsset updated = null;
                    try {
                        updated = service.update(record);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
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

    @PostMapping(path = {"/assign"}, consumes={"application/json"})
    public PhysicalAsset assignWorkerToAsset(@RequestBody AssignAssetsWorkers assignAssetsWorkers) throws Exception {
        return service.assignWorkerToAsset(assignAssetsWorkers);
    }
}