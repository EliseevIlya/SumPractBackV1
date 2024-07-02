package com.example.sumpractbackv1.repository;

import com.example.sumpractbackv1.entity.ImportData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImportDataRepository extends JpaRepository<ImportData, Long> {

}
