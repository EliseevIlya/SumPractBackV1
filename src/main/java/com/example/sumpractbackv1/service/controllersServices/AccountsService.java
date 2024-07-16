package com.example.sumpractbackv1.service.controllersServices;

import com.example.sumpractbackv1.model.dto.ResponseDto;
import com.example.sumpractbackv1.model.dto.search.AccountsSearchCriteria;
import com.example.sumpractbackv1.model.entity.Accounts;
import com.example.sumpractbackv1.repository.AccountsRepository;
import com.example.sumpractbackv1.util.specifications.AccountsSpecifications;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;



@RequiredArgsConstructor
@Service
@Transactional
public class AccountsService {

    private final AccountsRepository accountsRepository;

    public ResponseDto<Accounts> searchAccounts(AccountsSearchCriteria criteria) {
        Specification<Accounts> spec = AccountsSpecifications.byCriteria(criteria);
        Pageable pageable = PageRequest.of(criteria.getPage(), criteria.getSize(), Sort.by("id"));
        return new ResponseDto<>(accountsRepository.findAll(spec,pageable));
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
