package com.example.sumpractbackv1.service.controllersServices;

import com.example.sumpractbackv1.model.dto.ResponseDto;
import com.example.sumpractbackv1.model.dto.request.ImportDataRequest;
import com.example.sumpractbackv1.model.dto.search.ImportDataSearchCriteria;
import com.example.sumpractbackv1.model.entity.BicDirectoryEntry;
import com.example.sumpractbackv1.model.entity.ImportData;
import com.example.sumpractbackv1.model.entity.InitialEd;
import com.example.sumpractbackv1.model.entity.PartInfo;
import com.example.sumpractbackv1.repository.BICDirectoryEntryRepository;
import com.example.sumpractbackv1.repository.ImportDataRepository;
import com.example.sumpractbackv1.repository.InitialEdRepository;
import com.example.sumpractbackv1.repository.PartInfoRepository;
import com.example.sumpractbackv1.util.specifications.ImportDataSpecifications;
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
public class ImportDataService {
    private final ImportDataRepository importDataRepository;
    private final PartInfoRepository partInfoRepository;
    private final InitialEdRepository initialEdRepository;
    private final BICDirectoryEntryRepository bicDirectoryEntryRepository;

    public ResponseDto<ImportData> searchImportData(ImportDataSearchCriteria criteria) {
        Specification<ImportData> spec = ImportDataSpecifications.byCriteria(criteria);
        Pageable pageable = PageRequest.of(criteria.getPage(), criteria.getSize(), Sort.by("id"));
        return new ResponseDto<>(importDataRepository.findAll(spec, pageable));
    }

    public ImportData saveImportData(ImportDataRequest importData) {
        PartInfo partInfo = importData.getPartInfo() != null
                ? partInfoRepository.findById(importData.getPartInfo()).orElse(null)
                : null;
        InitialEd initialEd = importData.getInitialED() != null
                ? initialEdRepository.findById(importData.getInitialED()).orElse(null)
                : null;
        List<BicDirectoryEntry> bicDirectoryEntries = bicDirectoryEntryRepository.findAllById(
                importData.getBicDirectoryEntryList()
        );
        ImportData currentImportData = importData.getId() != null
                ? importDataRepository.findById(importData.getId()).orElse(null)
                : null;

        ImportData importDataEntity = importData.toImportData();
        importDataEntity.setPartInfo(partInfo);
        importDataEntity.setInitialED(initialEd);
        importDataEntity.setBicDirectoryEntryList(bicDirectoryEntries);

        if (currentImportData != null) {
            importDataEntity.setCreatedDate(currentImportData.getCreatedDate());
            importDataEntity.setCreatedBy(currentImportData.getCreatedBy());

            currentImportData.getBicDirectoryEntryList()
                    .forEach(bicDirectoryEntry -> bicDirectoryEntry.setImportData(null));
        }

        bicDirectoryEntries.forEach(bicDirectoryEntry -> bicDirectoryEntry.setImportData(importDataEntity));
        if (partInfo != null)
            partInfo.setImportData(importDataEntity);
        if (initialEd != null)
            initialEd.setImportData(importDataEntity);

        return importDataRepository.save(importDataEntity);
    }

    public void deleteImportDataById(Long id) {
        importDataRepository.deleteById(id);
    }

    public boolean existsImportDataById(Long id) {
        return importDataRepository.existsById(id);
    }
}
