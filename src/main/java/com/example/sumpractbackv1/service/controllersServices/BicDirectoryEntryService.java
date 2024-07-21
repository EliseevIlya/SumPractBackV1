package com.example.sumpractbackv1.service.controllersServices;

import com.example.sumpractbackv1.model.dto.ResponseDto;
import com.example.sumpractbackv1.model.dto.request.BicDirectoryEntryRequest;
import com.example.sumpractbackv1.model.dto.search.BicDirectoryEntrySearchCriteria;
import com.example.sumpractbackv1.model.entity.*;
import com.example.sumpractbackv1.repository.*;
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
    private final ImportDataRepository importDataRepository;
    private final ParticipantInfoRepository participantInfoRepository;
    private final SwbicsRepository swbicsRepository;
    private final AccountsRepository accountsRepository;

    public ResponseDto<BicDirectoryEntry> searchBicDirectoryEntries(BicDirectoryEntrySearchCriteria criteria) {
        Specification<BicDirectoryEntry> spec = BicDirectoryEntrySpecifications.byCriteria(criteria);
        Pageable pageable = PageRequest.of(criteria.getPage(), criteria.getSize(), Sort.by("id"));
        return new ResponseDto<>(bicDirectoryEntryRepository.findAll(spec, pageable));
    }

    public BicDirectoryEntry saveBicDirectoryEntry(BicDirectoryEntryRequest bicDirectoryEntry) {
        ImportData importData = bicDirectoryEntry.getImportData() != null
                ? importDataRepository.findById(bicDirectoryEntry.getImportData()).orElse(null)
                : null;
        ParticipantInfo participantInfo = bicDirectoryEntry.getParticipantInfo() != null
                ? participantInfoRepository.findById(bicDirectoryEntry.getParticipantInfo()).orElse(null)
                : null;
        List<Swbics> swbicsList = swbicsRepository.findAllById(
                bicDirectoryEntry.getSwbicsList()
        );
        List<Accounts> accountsList = accountsRepository.findAllById(
                bicDirectoryEntry.getAccountsList()
        );
        BicDirectoryEntry currentBicDirectoryEntry = bicDirectoryEntry.getId() != null
                ? bicDirectoryEntryRepository.findById(bicDirectoryEntry.getId()).orElse(null)
                : null;

        BicDirectoryEntry bicDirectoryEntryEntity = bicDirectoryEntry.toBicDirectoryEntry();
        bicDirectoryEntryEntity.setImportData(importData);
        bicDirectoryEntryEntity.setParticipantInfo(participantInfo);
        bicDirectoryEntryEntity.setSwbicsList(swbicsList);
        bicDirectoryEntryEntity.setAccountsList(accountsList);
        if (currentBicDirectoryEntry != null) {
            bicDirectoryEntryEntity.setCreatedDate(currentBicDirectoryEntry.getCreatedDate());
            bicDirectoryEntryEntity.setCreatedBy(currentBicDirectoryEntry.getCreatedBy());

            currentBicDirectoryEntry.getSwbicsList()
                    .forEach(swbics -> swbics.setBicDirectoryEntry(null));
            currentBicDirectoryEntry.getAccountsList()
                    .forEach(accounts -> accounts.setBicDirectoryEntry(null));
        }

        swbicsList.forEach(swbics -> swbics.setBicDirectoryEntry(bicDirectoryEntryEntity));
        accountsList.forEach(accounts -> accounts.setBicDirectoryEntry(bicDirectoryEntryEntity));

        if (importData != null)
            importData.getBicDirectoryEntryList().add(bicDirectoryEntryEntity);

        if (participantInfo != null)
            participantInfo.setBicDirectoryEntry(bicDirectoryEntryEntity);

        return bicDirectoryEntryRepository.save(bicDirectoryEntryEntity);
    }

    public void deleteBicDirectoryEntryById(Long id) {
        bicDirectoryEntryRepository.deleteById(id);
    }

    public boolean existsBicDirectoryEntryById(Long id) {
        return bicDirectoryEntryRepository.existsById(id);
    }
}
