package com.cenfotec.assets.repository;

import com.cenfotec.assets.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long>, PagingAndSortingRepository<Worker, Long> {
}
