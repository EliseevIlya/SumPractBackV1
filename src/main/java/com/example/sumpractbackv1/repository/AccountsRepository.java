package com.example.sumpractbackv1.repository;

import com.example.sumpractbackv1.model.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long>, JpaSpecificationExecutor<Accounts> {

    @Query("UPDATE Accounts SET deleted = true WHERE id = ?1")
    void softDeleteById(Long accounts_id);

}
