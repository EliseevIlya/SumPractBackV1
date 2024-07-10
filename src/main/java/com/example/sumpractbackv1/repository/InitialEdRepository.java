package com.example.sumpractbackv1.repository;

import com.example.sumpractbackv1.model.entity.InitialED;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InitialEdRepository extends JpaRepository<InitialED, Long> {
}
