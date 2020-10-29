package com.cenfotec.assets.service;

import com.cenfotec.assets.model.Worker;

import java.util.List;
import java.util.Optional;

public interface IWorkerService {
    public Worker save(Worker worker);
    public Worker update(Worker worker);
    public void delete(Long id);
    public List<Worker> getAll();
    public Optional<Worker> getById(Long id);
}
