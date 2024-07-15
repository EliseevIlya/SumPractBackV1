package com.example.sumpractbackv1.service.controllersServices;

import com.example.sumpractbackv1.model.dto.search.AccountsSearchCriteria;
import com.example.sumpractbackv1.model.entity.Accounts;
import com.example.sumpractbackv1.repository.AccountsRepository;
import com.example.sumpractbackv1.util.specifications.AccountsSpecifications;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class AccountsService {

    private final AccountsRepository accountsRepository;

    public List<Accounts> searchAccounts(AccountsSearchCriteria criteria) {
        Specification<Accounts> spec = AccountsSpecifications.byCriteria(criteria);
        return accountsRepository.findAll(spec);
    }

    //TODO логику для прокидывания родителя и дочерних
    public void saveAccount( Accounts accounts) {
        accountsRepository.saveAndFlush(accounts);
    }

    public void deleteAccountById(Long id) {
        accountsRepository.deleteById(id);
    }

    public boolean existsAccountById(Long id) {
        return accountsRepository.existsById(id);
    }
}
