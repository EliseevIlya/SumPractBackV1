package com.example.sumpractbackv1.Repository;

import com.example.sumpractbackv1.DBEntity.RstrList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RstrListRepository extends JpaRepository<RstrList, Long> {
}
