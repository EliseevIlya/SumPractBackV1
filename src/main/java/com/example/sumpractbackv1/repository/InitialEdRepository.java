package com.example.sumpractbackv1.repository;

import com.example.sumpractbackv1.model.entity.InitialEd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface InitialEdRepository extends JpaRepository<InitialEd, Long>, JpaSpecificationExecutor<InitialEd> {
}
