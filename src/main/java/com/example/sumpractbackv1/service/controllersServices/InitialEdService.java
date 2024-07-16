package com.example.sumpractbackv1.service.controllersServices;

import com.example.sumpractbackv1.model.dto.ResponseDto;
import com.example.sumpractbackv1.model.dto.search.InitialEdSearchCriteria;
import com.example.sumpractbackv1.model.entity.InitialEd;
import com.example.sumpractbackv1.repository.InitialEdRepository;
import com.example.sumpractbackv1.util.specifications.InitialEdSpecifications;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class InitialEdService {
    private final InitialEdRepository initialEDRepository;

    public ResponseDto<InitialEd> searchInitialEd(InitialEdSearchCriteria criteria) {
        Specification<InitialEd> spec = InitialEdSpecifications.byCriteria(criteria);
        Pageable pageable = PageRequest.of(criteria.getPage(), criteria.getSize(), Sort.by("id"));
        return new ResponseDto<>(initialEDRepository.findAll(spec,pageable));
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
