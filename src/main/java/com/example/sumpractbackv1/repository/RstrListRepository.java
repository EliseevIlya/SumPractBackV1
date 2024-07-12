package com.example.sumpractbackv1.repository;

import com.example.sumpractbackv1.model.entity.RstrList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RstrListRepository extends JpaRepository<RstrList, Long>, JpaSpecificationExecutor<RstrList> {
}
