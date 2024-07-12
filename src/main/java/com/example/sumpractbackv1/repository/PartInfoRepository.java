package com.example.sumpractbackv1.repository;

import com.example.sumpractbackv1.model.entity.PartInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PartInfoRepository extends JpaRepository<PartInfo, Long>, JpaSpecificationExecutor<PartInfo> {
}
