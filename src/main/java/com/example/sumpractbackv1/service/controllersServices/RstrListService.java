package com.example.sumpractbackv1.service.controllersServices;

import com.example.sumpractbackv1.model.dto.search.RstrListSearchCriteria;
import com.example.sumpractbackv1.model.entity.RstrList;
import com.example.sumpractbackv1.repository.RstrListRepository;
import com.example.sumpractbackv1.util.specifications.RstrListSpecifications;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class RstrListService {
    private final RstrListRepository rstrListRepository;

    public List<RstrList> searchRstrList(RstrListSearchCriteria criteria) {
        Specification<RstrList> spec = RstrListSpecifications.byCriteria(criteria);
        return rstrListRepository.findAll(spec);
    }

    //TODO логику для прокидывания родителя и дочерних

    public void saveRstrList(RstrList rstrList) {
        rstrListRepository.save(rstrList);
    }

    public void deleteRstrListById(Long id) {
        rstrListRepository.deleteById(id);
    }

    public boolean existsRstrListById(Long id) {
        return rstrListRepository.existsById(id);
    }
}
