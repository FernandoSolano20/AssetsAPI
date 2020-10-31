package com.cenfotec.assets.service;

import com.cenfotec.assets.model.AssignAssetsWorkers;

import java.util.List;
import java.util.Optional;

public interface IAssignAssetsWorkersService {
    public AssignAssetsWorkers save(AssignAssetsWorkers assignAssetsWorkers);
    public AssignAssetsWorkers update(AssignAssetsWorkers assignAssetsWorkers);
    public void delete(Long id);
    public List<AssignAssetsWorkers> getAll();
    public Optional<AssignAssetsWorkers> getById(Long id);
}
