package com.example.sumpractbackv1.service.controllersServices;

import com.example.sumpractbackv1.model.dto.ResponseDto;
import com.example.sumpractbackv1.model.dto.request.PartInfoRequest;
import com.example.sumpractbackv1.model.dto.search.PartInfoSearchCriteria;
import com.example.sumpractbackv1.model.entity.ImportData;
import com.example.sumpractbackv1.model.entity.PartInfo;
import com.example.sumpractbackv1.repository.ImportDataRepository;
import com.example.sumpractbackv1.repository.PartInfoRepository;
import com.example.sumpractbackv1.util.specifications.PartInfoSpecifications;
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
public class PartInfoService {
    private final PartInfoRepository partInfoRepository;
    private final ImportDataRepository importDataRepository;

    public ResponseDto<PartInfo> searchPartInfo(PartInfoSearchCriteria criteria) {
        Specification<PartInfo> spec = PartInfoSpecifications.byCriteria(criteria);
        Pageable pageable = PageRequest.of(criteria.getPage(), criteria.getSize(), Sort.by("id"));
        return new ResponseDto<>(partInfoRepository.findAll(spec, pageable));
    }

    public PartInfo savePartInfo(PartInfoRequest partInfo) {
        ImportData importData = partInfo.getImportData() != null
                ? importDataRepository.findById(partInfo.getImportData()).orElse(null)
                : null;
        PartInfo currentPartInfo = partInfo.getId() != null
                ? partInfoRepository.findById(partInfo.getId()).orElse(null)
                : null;

        PartInfo partInfoEntity = partInfo.toPartInfo();
        partInfoEntity.setImportData(importData);

        if (currentPartInfo != null) {
            partInfoEntity.setCreatedDate(currentPartInfo.getCreatedDate());
            partInfoEntity.setCreatedBy(currentPartInfo.getCreatedBy());
        }
        if (importData != null) importData.setPartInfo(partInfoEntity);

        return partInfoRepository.save(partInfoEntity);
    }

    public void deletePartInfoById(Long id) {
        partInfoRepository.deleteById(id);
    }

    public boolean existsPartInfoById(Long id) {
        return partInfoRepository.existsById(id);
    }

}
