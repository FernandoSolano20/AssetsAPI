package com.cenfotec.assets.repository;

import com.cenfotec.assets.model.AssignAssetsWorkers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AssignAssetsWorkersRepository extends JpaRepository<AssignAssetsWorkers, Long>, PagingAndSortingRepository<AssignAssetsWorkers, Long> {
}