package com.example.sumpractbackv1.util.specifications;

import com.example.sumpractbackv1.model.dto.search.RstrListSearchCriteria;
import com.example.sumpractbackv1.model.entity.RstrList;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class RstrListSpecifications {

    public static Specification<RstrList> byCriteria(RstrListSearchCriteria criteria) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Поля RstrList
            if (criteria.getRstr() != null && !criteria.getRstr().isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("rstr"), criteria.getRstr()));
            }
            if (criteria.getRstrDate() != null) {
                predicates.add(criteriaBuilder.equal(root.get("rstrDate"), criteria.getRstrDate()));
            }
            if (criteria.getParticipantInfoRstrListId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("participantInfoRstrListId"), criteria.getParticipantInfoRstrListId()));
            }

            // Поля BaseEntity
            predicates.addAll(BaseEntitySpecifications.byBaseCriteria(root, query, criteriaBuilder, criteria));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}

