package com.example.sumpractbackv1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sumpractbackv1.model.entity.PartInfo;

@Repository
public interface PartInfoRepository extends JpaRepository<PartInfo, Long> {
}
