package com.cenfotec.assets.repository;

import com.cenfotec.assets.model.PhysicalAsset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhysicalAssetRepository extends JpaRepository<PhysicalAsset, Long>, PagingAndSortingRepository<PhysicalAsset, Long> {
}
