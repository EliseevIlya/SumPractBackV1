package com.example.sumpractbackv1.Repository;

import com.example.sumpractbackv1.DBEntity.ParticipantInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantInfoRepository extends JpaRepository<ParticipantInfo, Long> {
}
