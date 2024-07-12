package com.example.sumpractbackv1.repository;

import com.example.sumpractbackv1.model.entity.BICDirectoryEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BICDirectoryEntryRepository extends JpaRepository<BICDirectoryEntry, Long>, JpaSpecificationExecutor<BICDirectoryEntry> {
}
