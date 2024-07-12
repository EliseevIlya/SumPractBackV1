package com.example.sumpractbackv1.repository;

import com.example.sumpractbackv1.model.entity.AccRstrList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AccRstrListRepository extends JpaRepository<AccRstrList, Long>, JpaSpecificationExecutor<AccRstrList> {

}
