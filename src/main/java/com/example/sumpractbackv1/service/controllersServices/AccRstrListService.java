package com.example.sumpractbackv1.service.controllersServices;

import com.example.sumpractbackv1.model.dto.ResponseDto;
import com.example.sumpractbackv1.model.dto.request.AccRstrListRequest;
import com.example.sumpractbackv1.model.dto.search.AccRstrListSearchCriteria;
import com.example.sumpractbackv1.model.entity.AccRstrList;
import com.example.sumpractbackv1.model.entity.Accounts;
import com.example.sumpractbackv1.repository.AccRstrListRepository;
import com.example.sumpractbackv1.repository.AccountsRepository;
import com.example.sumpractbackv1.util.specifications.AccRstrListSpecifications;
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
public class AccRstrListService {
    private final AccRstrListRepository accRstrListRepository;
    private final AccountsRepository accountsRepository;

    public ResponseDto<AccRstrList> searchAccRstrList(AccRstrListSearchCriteria criteria) {
        Specification<AccRstrList> spec = AccRstrListSpecifications.byCriteria(criteria);
        Pageable pageable = PageRequest.of(criteria.getPage(), criteria.getSize(), Sort.by("id"));
        return new ResponseDto<>(accRstrListRepository.findAll(spec, pageable));
    }

    public AccRstrList saveAccRstrList(AccRstrListRequest accRstrList) {
        Accounts accounts = accRstrList.getAccounts() != null
                ? accountsRepository.findById(accRstrList.getAccounts()).orElse(null)
                : null;
        AccRstrList currentAccRstrList = accRstrList.getId() != null
                ? accRstrListRepository.findById(accRstrList.getId()).orElse(null)
                : null;

        AccRstrList accRstrListEntity = accRstrList.toAccRstrList();

        accRstrListEntity.setAccounts(accounts);
        if (accounts != null) accounts.getAccRstrLists().add(accRstrListEntity);

        if (currentAccRstrList != null) {
            accRstrListEntity.setCreatedDate(currentAccRstrList.getCreatedDate());
            accRstrListEntity.setCreatedBy(currentAccRstrList.getCreatedBy());
        }

        return accRstrListRepository.save(accRstrListEntity);
    }

    public void deleteAccRstrListById(Long id) {
        accRstrListRepository.deleteById(id);
    }

    public boolean existsAccRstrListById(Long id) {
        return accRstrListRepository.existsById(id);
    }
}
