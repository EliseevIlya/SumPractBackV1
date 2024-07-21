package com.example.sumpractbackv1.service.controllersServices;

import com.example.sumpractbackv1.model.dto.ResponseDto;
import com.example.sumpractbackv1.model.dto.request.ParticipantInfoRequest;
import com.example.sumpractbackv1.model.dto.search.ParticipantInfoSearchCriteria;
import com.example.sumpractbackv1.model.entity.BicDirectoryEntry;
import com.example.sumpractbackv1.model.entity.ParticipantInfo;
import com.example.sumpractbackv1.model.entity.RstrList;
import com.example.sumpractbackv1.repository.BICDirectoryEntryRepository;
import com.example.sumpractbackv1.repository.ParticipantInfoRepository;
import com.example.sumpractbackv1.repository.RstrListRepository;
import com.example.sumpractbackv1.util.specifications.ParticipantInfoSpecifications;
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
public class ParticipantInfoService {
    private final ParticipantInfoRepository participantInfoRepository;
    private final BICDirectoryEntryRepository bicDirectoryEntryRepository;
    private final RstrListRepository rstrListRepository;

    public ResponseDto<ParticipantInfo> searchParticipantInfo(ParticipantInfoSearchCriteria criteria) {
        Specification<ParticipantInfo> spec = ParticipantInfoSpecifications.byCriteria(criteria);
        Pageable pageable = PageRequest.of(criteria.getPage(), criteria.getSize(), Sort.by("id"));
        return new ResponseDto<>(participantInfoRepository.findAll(spec, pageable));
    }

    public ParticipantInfo saveParticipantInfo(ParticipantInfoRequest participantInfo) {
        BicDirectoryEntry bicDirectoryEntry = participantInfo.getBicDirectoryEntry() != null
                ? bicDirectoryEntryRepository.findById(participantInfo.getBicDirectoryEntry()).orElse(null)
                : null;
        List<RstrList> rstrLists = rstrListRepository.findAllById(
                participantInfo.getRstrLists()
        );
        ParticipantInfo currentParticipantInfo = participantInfo.getId() != null
                ? participantInfoRepository.findById(participantInfo.getId()).orElse(null)
                : null;

        ParticipantInfo participantInfoEntity = participantInfo.toParticipantInfo();
        participantInfoEntity.setBicDirectoryEntry(bicDirectoryEntry);
        participantInfoEntity.setRstrLists(rstrLists);

        if (currentParticipantInfo != null) {
            participantInfoEntity.setCreatedDate(currentParticipantInfo.getCreatedDate());
            participantInfoEntity.setCreatedBy(currentParticipantInfo.getCreatedBy());

            currentParticipantInfo.getRstrLists()
                    .forEach(rstrList -> rstrList.setParticipantInfo(null));
        }

        rstrLists.forEach(rstrList -> rstrList.setParticipantInfo(participantInfoEntity));
        if (bicDirectoryEntry != null)
            bicDirectoryEntry.setParticipantInfo(participantInfoEntity);

        return participantInfoRepository.save(participantInfoEntity);
    }

    public void deleteParticipantInfoById(Long id) {
        participantInfoRepository.deleteById(id);
    }

    public boolean existsParticipantInfoById(Long id) {
        return participantInfoRepository.existsById(id);
    }
}
