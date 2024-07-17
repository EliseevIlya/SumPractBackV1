package com.example.sumpractbackv1.service.controllersServices;

import com.example.sumpractbackv1.model.dto.ResponseDto;
import com.example.sumpractbackv1.model.dto.request.InitialEdRequest;
import com.example.sumpractbackv1.model.dto.search.InitialEdSearchCriteria;
import com.example.sumpractbackv1.model.entity.ImportData;
import com.example.sumpractbackv1.model.entity.InitialEd;
import com.example.sumpractbackv1.repository.ImportDataRepository;
import com.example.sumpractbackv1.repository.InitialEdRepository;
import com.example.sumpractbackv1.util.specifications.InitialEdSpecifications;
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
public class InitialEdService {
    private final InitialEdRepository initialEDRepository;
    private final ImportDataRepository importDataRepository;

    public ResponseDto<InitialEd> searchInitialEd(InitialEdSearchCriteria criteria) {
        Specification<InitialEd> spec = InitialEdSpecifications.byCriteria(criteria);
        Pageable pageable = PageRequest.of(criteria.getPage(), criteria.getSize(), Sort.by("id"));
        return new ResponseDto<>(initialEDRepository.findAll(spec, pageable));
    }

    public InitialEd saveInitialED(InitialEdRequest initialED) {
        ImportData importData = initialED.getImportData() != null
            ? importDataRepository.findById(initialED.getImportData()).orElse(null)
            : null;
        InitialEd currentInitialED = initialED.getId() != null
            ? initialEDRepository.findById(initialED.getId()).orElse(null)
            : null;

        InitialEd initialEDEntity = initialED.toInitialEd();
        initialEDEntity.setImportData(importData);

        if (currentInitialED != null) {
            initialEDEntity.setCreatedDate(currentInitialED.getCreatedDate());
            initialEDEntity.setCreatedBy(currentInitialED.getCreatedBy());
        }

        if (importData != null) importData.setInitialED(initialEDEntity);

        return initialEDRepository.save(initialEDEntity);
    }

    public void deleteInitialEDById(Long id) {
        initialEDRepository.deleteById(id);
    }

    public boolean existsInitialEDById(Long id) {
        return initialEDRepository.existsById(id);
    }

}
