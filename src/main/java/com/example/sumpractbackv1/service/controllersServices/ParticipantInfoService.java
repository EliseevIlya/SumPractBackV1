package com.example.sumpractbackv1.service.controllersServices;

import com.example.sumpractbackv1.model.dto.ResponseDto;
import com.example.sumpractbackv1.model.dto.search.ParticipantInfoSearchCriteria;
import com.example.sumpractbackv1.model.entity.ParticipantInfo;
import com.example.sumpractbackv1.repository.ParticipantInfoRepository;
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

    public ResponseDto<ParticipantInfo> searchParticipantInfo(ParticipantInfoSearchCriteria criteria) {
        Specification<ParticipantInfo> spec = ParticipantInfoSpecifications.byCriteria(criteria);
        Pageable pageable = PageRequest.of(criteria.getPage(), criteria.getSize(), Sort.by("id"));
        return new ResponseDto<>(participantInfoRepository.findAll(spec,pageable));
    }
    //TODO логику для прокидывания родителя и дочерних

    public void saveParticipantInfo(ParticipantInfo participantInfo) {
        participantInfoRepository.save(participantInfo);
    }

    public void deleteParticipantInfoById(Long id) {
        participantInfoRepository.deleteById(id);
    }

    public boolean existsParticipantInfoById(Long id) {
        return participantInfoRepository.existsById(id);
    }
}
