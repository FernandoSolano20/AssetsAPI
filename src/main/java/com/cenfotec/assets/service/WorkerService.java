package com.cenfotec.assets.service;

import com.cenfotec.assets.model.Worker;
import com.cenfotec.assets.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerService implements IWorkerService {
    @Autowired
    WorkerRepository repository;

    @Override
    public Worker save(Worker worker) {
        return repository.save(worker);
    }

    @Override
    public Worker update(Worker worker) {
        return repository.save(worker);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Worker> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Worker> getById(Long id) {
        return repository.findById(id);
    }
}
