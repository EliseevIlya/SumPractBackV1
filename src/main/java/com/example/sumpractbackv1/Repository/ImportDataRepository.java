package com.example.sumpractbackv1.Repository;

import com.example.sumpractbackv1.DBEntity.ImportData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImportDataRepository extends JpaRepository<ImportData, Long> {

}
