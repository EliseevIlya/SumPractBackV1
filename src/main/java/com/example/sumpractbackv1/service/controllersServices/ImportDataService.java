package com.example.sumpractbackv1.service.controllersServices;

import com.example.sumpractbackv1.model.dto.search.ImportDataSearchCriteria;
import com.example.sumpractbackv1.model.entity.ImportData;
import com.example.sumpractbackv1.repository.ImportDataRepository;
import com.example.sumpractbackv1.util.specifications.ImportDataSpecifications;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class ImportDataService {
    private final ImportDataRepository importDataRepository;

    public List<ImportData> searchImportData(ImportDataSearchCriteria criteria) {
        Specification<ImportData> spec = ImportDataSpecifications.byCriteria(criteria);
        return importDataRepository.findAll(spec);
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
