package com.example.sumpractbackv1.service.controllersServices;

import com.example.sumpractbackv1.model.dto.ResponseDto;
import com.example.sumpractbackv1.model.dto.search.ImportDataSearchCriteria;
import com.example.sumpractbackv1.model.entity.ImportData;
import com.example.sumpractbackv1.repository.ImportDataRepository;
import com.example.sumpractbackv1.util.specifications.ImportDataSpecifications;
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
public class ImportDataService {
    private final ImportDataRepository importDataRepository;

    public ResponseDto<ImportData> searchImportData(ImportDataSearchCriteria criteria) {
        Specification<ImportData> spec = ImportDataSpecifications.byCriteria(criteria);
        Pageable pageable = PageRequest.of(criteria.getPage(), criteria.getSize(), Sort.by("id"));
        return new ResponseDto<>(importDataRepository.findAll(spec, pageable));
    }
    //TODO логику для прокидывания родителя и дочерних

    public void saveImportData(ImportData importData) {
        importDataRepository.save(importData);
    }

    public void deleteImportDataById(Long id) {
        importDataRepository.deleteById(id);
    }

    public boolean existsImportDataById(Long id) {
        return importDataRepository.existsById(id);
    }
}
