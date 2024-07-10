package com.example.sumpractbackv1.repository;

import com.example.sumpractbackv1.model.entity.Swbics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SwbicsRepository extends JpaRepository<Swbics, Long> {
}
