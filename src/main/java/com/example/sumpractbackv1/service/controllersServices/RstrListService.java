package com.example.sumpractbackv1.service.controllersServices;

import com.example.sumpractbackv1.model.dto.ResponseDto;
import com.example.sumpractbackv1.model.dto.request.RstrListRequest;
import com.example.sumpractbackv1.model.dto.search.RstrListSearchCriteria;
import com.example.sumpractbackv1.model.entity.ParticipantInfo;
import com.example.sumpractbackv1.model.entity.RstrList;
import com.example.sumpractbackv1.repository.ParticipantInfoRepository;
import com.example.sumpractbackv1.repository.RstrListRepository;
import com.example.sumpractbackv1.util.specifications.RstrListSpecifications;
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
public class RstrListService {
    private final RstrListRepository rstrListRepository;
    private final ParticipantInfoRepository participantInfoRepository;

    public ResponseDto<RstrList> searchRstrList(RstrListSearchCriteria criteria) {
        Specification<RstrList> spec = RstrListSpecifications.byCriteria(criteria);
        Pageable pageable = PageRequest.of(criteria.getPage(), criteria.getSize(), Sort.by("id"));
        return new ResponseDto<>(rstrListRepository.findAll(spec, pageable));
    }

    public RstrList saveRstrList(RstrListRequest rstrList) {
        ParticipantInfo participantInfo = rstrList.getParticipantInfo() != null
            ? participantInfoRepository.findById(rstrList.getParticipantInfo()).orElse(null)
            : null;
        RstrList currentRstrList = rstrList.getId() != null
            ? rstrListRepository.findById(rstrList.getId()).orElse(null)
            : null;

        RstrList rstrListEntity = rstrList.toRstrList();
        rstrListEntity.setParticipantInfo(participantInfo);
        if (currentRstrList != null) {
            rstrListEntity.setCreatedDate(currentRstrList.getCreatedDate());
            rstrListEntity.setCreatedBy(currentRstrList.getCreatedBy());
        }
        if (participantInfo != null) participantInfo.getRstrLists().add(rstrListEntity);

        return rstrListRepository.save(rstrListEntity);
    }

    public void deleteRstrListById(Long id) {
        rstrListRepository.deleteById(id);
    }

    public boolean existsRstrListById(Long id) {
        return rstrListRepository.existsById(id);
    }
}
