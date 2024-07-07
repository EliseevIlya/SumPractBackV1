package com.example.sumpractbackv1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sumpractbackv1.model.entity.PartInfo;

public interface PartInfoRepository extends JpaRepository<PartInfo, Long> {
}
