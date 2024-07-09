package com.example.sumpractbackv1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sumpractbackv1.model.entity.RstrList;

@Repository
public interface RstrListRepository extends JpaRepository<RstrList, Long> {
}
