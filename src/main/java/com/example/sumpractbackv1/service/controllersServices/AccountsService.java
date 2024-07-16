package com.example.sumpractbackv1.service.controllersServices;

import com.example.sumpractbackv1.model.dto.request.AccountsRequest;
import com.example.sumpractbackv1.model.dto.search.AccountsSearchCriteria;
import com.example.sumpractbackv1.model.entity.AccRstrList;
import com.example.sumpractbackv1.model.entity.Accounts;
import com.example.sumpractbackv1.model.entity.BicDirectoryEntry;
import com.example.sumpractbackv1.repository.AccRstrListRepository;
import com.example.sumpractbackv1.repository.AccountsRepository;
import com.example.sumpractbackv1.repository.BICDirectoryEntryRepository;
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
    private final AccRstrListRepository accRstrListRepository;
    private final BICDirectoryEntryRepository bicDirectoryEntryRepository;

    public List<Accounts> searchAccounts(AccountsSearchCriteria criteria) {
        Specification<Accounts> spec = AccountsSpecifications.byCriteria(criteria);
        return accountsRepository.findAll(spec);
    }

    public Accounts saveAccount(AccountsRequest accounts) {
        List<AccRstrList> accRstrLists = accRstrListRepository.findAllById(
            accounts.getAccRstrLists()
        );
        BicDirectoryEntry bicDirectoryEntry = bicDirectoryEntryRepository.findById(
            accounts.getBicDirectoryEntry()
        ).orElse(null);
        Accounts currentAccounts = accounts.getId() != null
            ? accountsRepository.findById(accounts.getId()).orElse(null)
            : null;

        Accounts accountsEntity = accounts.toAccounts();
        accountsEntity.setAccRstrLists(accRstrLists);
        accountsEntity.setBicDirectoryEntry(bicDirectoryEntry);

        if (currentAccounts != null) {
            currentAccounts.getAccRstrLists()
                .forEach(accRstrList -> accRstrList.setAccounts(null));
            if (currentAccounts.getBicDirectoryEntry() != null)
                currentAccounts.getBicDirectoryEntry().getAccountsList().remove(currentAccounts);
                
            accountsEntity.setCreatedDate(currentAccounts.getCreatedDate());
            accountsEntity.setCreatedBy(currentAccounts.getCreatedBy());
        }
        
        accRstrLists.forEach(accRstrList -> accRstrList.setAccounts(accountsEntity));
        if (bicDirectoryEntry != null)
            bicDirectoryEntry.getAccountsList().add(accountsEntity);

        return accountsRepository.save(accountsEntity);
    }

    public void deleteAccountById(Long id) {
        accountsRepository.deleteById(id);
    }

    public boolean existsAccountById(Long id) {
        return accountsRepository.existsById(id);
    }
}
