package com.example.sumpractbackv1.Repository;

import com.example.sumpractbackv1.DBEntity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long> {
}
