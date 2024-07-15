package com.example.sumpractbackv1.service.controllersServices;

import com.example.sumpractbackv1.model.dto.search.InitialEDSearchCriteria;
import com.example.sumpractbackv1.model.entity.InitialEd;
import com.example.sumpractbackv1.repository.InitialEdRepository;
import com.example.sumpractbackv1.util.specifications.InitialEDSpecifications;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class InitialEdService {
    private final InitialEdRepository initialEDRepository;

    public List<InitialEd> searchInitialED(InitialEDSearchCriteria criteria) {
        Specification<InitialEd> spec = InitialEDSpecifications.byCriteria(criteria);
        return initialEDRepository.findAll(spec);
    }
    //TODO логику для прокидывания родителя и дочерних

    public void saveInitialED(InitialEd initialED) {
        initialEDRepository.save(initialED);
    }

    public void deleteInitialEDById(Long id) {
        initialEDRepository.deleteById(id);
    }

    public boolean existsInitialEDById(Long id) {
        return initialEDRepository.existsById(id);
    }

}
