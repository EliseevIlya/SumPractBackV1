package com.example.sumpractbackv1.service.controllersServices;

import com.example.sumpractbackv1.model.dto.ResponseDto;
import com.example.sumpractbackv1.model.dto.search.SwbicsSearchCriteria;
import com.example.sumpractbackv1.model.entity.Swbics;
import com.example.sumpractbackv1.repository.SwbicsRepository;
import com.example.sumpractbackv1.util.specifications.SwbicsSpecifications;
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
public class SwbicsService {
    private final SwbicsRepository swbicsRepository;

    public ResponseDto<Swbics> searchSwbics(SwbicsSearchCriteria criteria) {
        Specification<Swbics> spec = SwbicsSpecifications.byCriteria(criteria);
        Pageable pageable = PageRequest.of(criteria.getPage(), criteria.getSize(), Sort.by("id"));
        return new ResponseDto<>(swbicsRepository.findAll(spec,pageable));
    }
    //TODO логику для прокидывания родителя и дочерних

    public void saveSwbics(Swbics swbics) {
        swbicsRepository.save(swbics);
    }

    public void deleteSwbicsById(Long id) {
        swbicsRepository.deleteById(id);
    }

    public boolean existsSwbicsById(Long id) {
        return swbicsRepository.existsById(id);
    }

}
