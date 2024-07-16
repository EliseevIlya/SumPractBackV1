package com.example.sumpractbackv1.service.controllersServices;

import com.example.sumpractbackv1.model.dto.search.AccRstrListSearchCriteria;
import com.example.sumpractbackv1.model.entity.AccRstrList;
import com.example.sumpractbackv1.repository.AccRstrListRepository;
import com.example.sumpractbackv1.util.specifications.AccRstrListSpecifications;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class AccRstrListService {
    private final AccRstrListRepository accRstrListRepository;

    public List<AccRstrList> searchAccRstrList(AccRstrListSearchCriteria criteria) {
        Specification<AccRstrList> spec = AccRstrListSpecifications.byCriteria(criteria);
        return accRstrListRepository.findAll(spec);
    }

    public void saveAccRstrList(AccRstrList accRstrList) {
        accRstrListRepository.save(accRstrList);
    }
    //TODO логику для прокидывания родителя и дочерних

    public void deleteAccRstrListById(Long id) {
        accRstrListRepository.deleteById(id);
    }

    public boolean existsAccRstrListById(Long id) {
        return accRstrListRepository.existsById(id);
    }
}
