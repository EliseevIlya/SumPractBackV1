package com.example.sumpractbackv1.repository;

import com.example.sumpractbackv1.model.entity.ParticipantInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantInfoRepository extends JpaRepository<ParticipantInfo, Long>, JpaSpecificationExecutor<ParticipantInfo> {
}
