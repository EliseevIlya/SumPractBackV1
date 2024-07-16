package com.example.sumpractbackv1.service.controllersServices;

import com.example.sumpractbackv1.model.dto.ResponseDto;
import com.example.sumpractbackv1.model.dto.search.BicDirectoryEntrySearchCriteria;
import com.example.sumpractbackv1.model.entity.BicDirectoryEntry;
import com.example.sumpractbackv1.repository.BICDirectoryEntryRepository;
import com.example.sumpractbackv1.util.specifications.BicDirectoryEntrySpecifications;
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
public class BicDirectoryEntryService {
    private final BICDirectoryEntryRepository bicDirectoryEntryRepository;

    public ResponseDto<BicDirectoryEntry> searchBicDirectoryEntries(BicDirectoryEntrySearchCriteria criteria) {
        Specification<BicDirectoryEntry> spec = BicDirectoryEntrySpecifications.byCriteria(criteria);
        Pageable pageable = PageRequest.of(criteria.getPage(), criteria.getSize(), Sort.by("id"));
        return new ResponseDto<>(bicDirectoryEntryRepository.findAll(spec,pageable));
    }
    //TODO логику для прокидывания родителя и дочерних

    public void saveBicDirectoryEntry(BicDirectoryEntry bicDirectoryEntry) {
        bicDirectoryEntryRepository.save(bicDirectoryEntry);
    }

    public void deleteBicDirectoryEntryById(Long id) {
        bicDirectoryEntryRepository.deleteById(id);
    }

    public boolean existsBicDirectoryEntryById(Long id) {
        return bicDirectoryEntryRepository.existsById(id);
    }
}
