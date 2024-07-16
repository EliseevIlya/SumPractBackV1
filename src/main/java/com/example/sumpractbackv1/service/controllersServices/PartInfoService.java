package com.example.sumpractbackv1.service.controllersServices;

import com.example.sumpractbackv1.model.dto.ResponseDto;
import com.example.sumpractbackv1.model.dto.search.PartInfoSearchCriteria;
import com.example.sumpractbackv1.model.entity.PartInfo;
import com.example.sumpractbackv1.repository.PartInfoRepository;
import com.example.sumpractbackv1.util.specifications.PartInfoSpecifications;
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
public class PartInfoService {
    private final PartInfoRepository partInfoRepository;

    public ResponseDto<PartInfo> searchPartInfo(PartInfoSearchCriteria criteria) {
        Specification<PartInfo> spec = PartInfoSpecifications.byCriteria(criteria);
        Pageable pageable = PageRequest.of(criteria.getPage(), criteria.getSize(), Sort.by("id"));
        return new ResponseDto<>(partInfoRepository.findAll(spec,pageable));
    }

    //TODO логику для прокидывания родителя и дочерних

    public void savePartInfo(PartInfo partInfo) {
        partInfoRepository.save(partInfo);
    }

    public void deletePartInfoById(Long id) {
        partInfoRepository.deleteById(id);
    }

    public boolean existsPartInfoById(Long id) {
        return partInfoRepository.existsById(id);
    }

}
