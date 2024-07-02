package com.example.sumpractbackv1.repository;

import com.example.sumpractbackv1.entity.TestEn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepo extends JpaRepository<TestEn, Long> {
}
