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
            if (criteria.getSearchNameP() != null && !criteria.getSearchNameP().isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("nameP"),
                        StaticUtils.likePattern(criteria.getSearchNameP())));
            }
            if (criteria.getSearchEnglName() != null && !criteria.getSearchEnglName().isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("englName"),
                        StaticUtils.likePattern(criteria.getSearchEnglName())));
            }
            if (criteria.getSearchRegN() != null && !criteria.getSearchRegN().isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("regN"),
                        StaticUtils.likePattern(criteria.getSearchRegN())));
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
            if (criteria.getSearchNnp() != null && !criteria.getSearchNnp().isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("nnp"),
                        StaticUtils.likePattern(criteria.getSearchNnp())));
            }
            if (criteria.getSearchAdr() != null && !criteria.getSearchAdr().isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("adr"),
                        StaticUtils.likePattern(criteria.getSearchAdr())));
            }
            if (criteria.getSearchPrntBIC() != null) {
                predicates.add(StaticUtils.likeBic(criteriaBuilder, root.get("prntBIC"),
                        criteria.getSearchPrntBIC()));
            }
            if (criteria.getFromDateInParticipant() != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("dateInParticipant"),
                        criteria.getFromDateInParticipant()));
            }
            if (criteria.getToDateInParticipant() != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("dateInParticipant"),
                        criteria.getToDateInParticipant()));
            }
            if (criteria.getFromDateOutParticipant() != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("dateOutParticipant"),
                        criteria.getFromDateOutParticipant()));
            }
            if (criteria.getToDateOutParticipant() != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("dateOutParticipant"),
                        criteria.getToDateOutParticipant()));
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
            if (criteria.getBicDirectoryEntryId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("bicDirectoryEntry").get("id"),
                        criteria.getBicDirectoryEntryId()));
            }

            // Поля BaseEntity
            predicates.addAll(BaseEntitySpecifications.byBaseCriteria(root, query, criteriaBuilder, criteria));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
