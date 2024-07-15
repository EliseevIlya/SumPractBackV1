package com.example.sumpractbackv1.service.controllersServices;

import com.example.sumpractbackv1.model.dto.search.BICDirectoryEntrySearchCriteria;
import com.example.sumpractbackv1.model.entity.BicDirectoryEntry;
import com.example.sumpractbackv1.repository.BICDirectoryEntryRepository;
import com.example.sumpractbackv1.util.specifications.BICDirectoryEntrySpecifications;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class BicDirectoryEntryService {
    private final BICDirectoryEntryRepository bicDirectoryEntryRepository;

    public List<BicDirectoryEntry> searchBICDirectoryEntries(BICDirectoryEntrySearchCriteria criteria) {
        Specification<BicDirectoryEntry> spec = BICDirectoryEntrySpecifications.byCriteria(criteria);
        return bicDirectoryEntryRepository.findAll(spec);
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
