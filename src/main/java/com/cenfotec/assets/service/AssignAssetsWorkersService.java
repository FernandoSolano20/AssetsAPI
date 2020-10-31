package com.cenfotec.assets.service;

import com.cenfotec.assets.model.AssignAssetsWorkers;
import com.cenfotec.assets.repository.AssignAssetsWorkersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignAssetsWorkersService implements IAssignAssetsWorkersService {
    @Autowired
    AssignAssetsWorkersRepository repository;

    @Override
    public AssignAssetsWorkers save(AssignAssetsWorkers assignAssetsWorkers) {
        return repository.save(assignAssetsWorkers);
    }

    @Override
    public AssignAssetsWorkers update(AssignAssetsWorkers assignAssetsWorkers) {
        return repository.save(assignAssetsWorkers);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<AssignAssetsWorkers> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<AssignAssetsWorkers> getById(Long id) {
        return repository.findById(id);
    }
}
