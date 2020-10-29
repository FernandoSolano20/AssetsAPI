package com.cenfotec.assets.repository;

import com.cenfotec.assets.model.AssetType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetTypeRepository extends JpaRepository<AssetType, Long>, PagingAndSortingRepository<AssetType, Long> {
}
