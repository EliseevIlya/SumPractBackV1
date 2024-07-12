package com.example.sumpractbackv1.util.specifications;

import com.example.sumpractbackv1.model.dto.search.ParticipantInfoSearchCriteria;
import com.example.sumpractbackv1.model.entity.ParticipantInfo;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class ParticipantInfoSpecifications {

    public static Specification<ParticipantInfo> byCriteria(ParticipantInfoSearchCriteria criteria) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Поля ParticipantInfo
            if (criteria.getNameP() != null && !criteria.getNameP().isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("nameP"), criteria.getNameP()));
            }
            if (criteria.getEnglName() != null && !criteria.getEnglName().isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("englName"), criteria.getEnglName()));
            }
            if (criteria.getRegN() != null && !criteria.getRegN().isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("regN"), criteria.getRegN()));
            }
            if (criteria.getCntrCd() != null && !criteria.getCntrCd().isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("cntrCd"), criteria.getCntrCd()));
            }
            if (criteria.getRgn() != null && !criteria.getRgn().isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("rgn"), criteria.getRgn()));
            }
            if (criteria.getInd() != null && !criteria.getInd().isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("ind"), criteria.getInd()));
            }
            if (criteria.getTnp() != null && !criteria.getTnp().isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("tnp"), criteria.getTnp()));
            }
            if (criteria.getNnp() != null && !criteria.getNnp().isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("nnp"), criteria.getNnp()));
            }
            if (criteria.getAdr() != null && !criteria.getAdr().isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("adr"), criteria.getAdr()));
            }
            if (criteria.getPrntBIC() != null) {
                predicates.add(criteriaBuilder.equal(root.get("prntBIC"), criteria.getPrntBIC()));
            }
            if (criteria.getDateInParticipant() != null) {
                predicates.add(criteriaBuilder.equal(root.get("dateInParticipant"), criteria.getDateInParticipant()));
            }
            if (criteria.getDateOutParticipant() != null) {
                predicates.add(criteriaBuilder.equal(root.get("dateOutParticipant"), criteria.getDateOutParticipant()));
            }
            if (criteria.getPtType() != null && !criteria.getPtType().isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("ptType"), criteria.getPtType()));
            }
            if (criteria.getSrvcs() != null && !criteria.getSrvcs().isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("srvcs"), criteria.getSrvcs()));
            }
            if (criteria.getXchType() != null && !criteria.getXchType().isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("xchType"), criteria.getXchType()));
            }
            if (criteria.getUid() != null) {
                predicates.add(criteriaBuilder.equal(root.get("uid"), criteria.getUid()));
            }
            if (criteria.getParticipantStatus() != null) {
                predicates.add(criteriaBuilder.equal(root.get("participantStatus"), criteria.getParticipantStatus()));
            }
            if (criteria.getBicParticipantInfoId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("bicParticipantInfoId"), criteria.getBicParticipantInfoId()));
            }

            // Поля BaseEntity
            predicates.addAll(BaseEntitySpecifications.byBaseCriteria(root, query, criteriaBuilder, criteria));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
