package com.cenfotec.assets.controllers;

import com.cenfotec.assets.model.Worker;
import com.cenfotec.assets.service.IWorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"api/workers"})
@CrossOrigin
public class WorkerController {
    @Autowired
    private IWorkerService service;

    @GetMapping
    public List findAll()
    {
        return service.getAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Worker> findById(@PathVariable Long id)
    {
        return service.getById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Worker create(@RequestBody Worker worker)
    {
        return service.save(worker);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Worker> update(@PathVariable("id") Long id, @RequestBody Worker worker)
    {
        return service.getById(id)
                .map(record -> {
                    record.setName(worker.getName());
                    record.setLastName(worker.getLastName());
                    record.setBirthday(worker.getBirthday());
                    record.setState(worker.getState());
                    Worker updated = service.save(record);
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
