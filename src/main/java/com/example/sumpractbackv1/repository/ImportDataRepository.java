package com.example.sumpractbackv1.repository;

import com.example.sumpractbackv1.model.entity.ImportData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImportDataRepository extends JpaRepository<ImportData, Long> {

    @Query("SELECT d FROM ImportData d WHERE d.id > ?1 ORDER BY d.id LIMIT ?2")
    List<ImportData> findWithPagination(long last_id, int limit);

}
