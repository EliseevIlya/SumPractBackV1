package com.example.sumpractbackv1.service.controllersServices;

import com.example.sumpractbackv1.model.dto.ResponseDto;
import com.example.sumpractbackv1.model.dto.request.SwbicsRequest;
import com.example.sumpractbackv1.model.dto.search.SwbicsSearchCriteria;
import com.example.sumpractbackv1.model.entity.BicDirectoryEntry;
import com.example.sumpractbackv1.model.entity.Swbics;
import com.example.sumpractbackv1.repository.BICDirectoryEntryRepository;
import com.example.sumpractbackv1.repository.SwbicsRepository;
import com.example.sumpractbackv1.util.specifications.SwbicsSpecifications;
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
public class SwbicsService {
    private final SwbicsRepository swbicsRepository;
    private final BICDirectoryEntryRepository bicDirectoryEntryRepository;

    public ResponseDto<Swbics> searchSwbics(SwbicsSearchCriteria criteria) {
        Specification<Swbics> spec = SwbicsSpecifications.byCriteria(criteria);
        Pageable pageable = PageRequest.of(criteria.getPage(), criteria.getSize(), Sort.by("id"));
        return new ResponseDto<>(swbicsRepository.findAll(spec, pageable));
    }

    public Swbics saveSwbics(SwbicsRequest swbics) {
        BicDirectoryEntry bicDirectoryEntry = swbics.getBicDirectoryEntry() != null
                ? bicDirectoryEntryRepository.findById(swbics.getBicDirectoryEntry()).orElse(null)
                : null;
        Swbics currentSwbics = swbics.getId() != null
                ? swbicsRepository.findById(swbics.getId()).orElse(null)
                : null;

        Swbics swbicsEntity = swbics.toSwbics();
        swbicsEntity.setBicDirectoryEntry(bicDirectoryEntry);

        if (currentSwbics != null) {
            swbicsEntity.setCreatedDate(currentSwbics.getCreatedDate());
            swbicsEntity.setCreatedBy(currentSwbics.getCreatedBy());
        }
        if (bicDirectoryEntry != null) bicDirectoryEntry.getSwbicsList().add(swbicsEntity);

        return swbicsRepository.save(swbicsEntity);
    }

    public void deleteSwbicsById(Long id) {
        swbicsRepository.deleteById(id);
    }

    public boolean existsSwbicsById(Long id) {
        return swbicsRepository.existsById(id);
    }

}
