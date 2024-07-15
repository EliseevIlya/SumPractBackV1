package com.example.sumpractbackv1.util.specifications;

import com.example.sumpractbackv1.model.dto.search.InitialEdSearchCriteria;
import com.example.sumpractbackv1.model.entity.InitialEd;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class InitialEdSpecifications {

    public static Specification<InitialEd> byCriteria(InitialEdSearchCriteria criteria) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Поля InitialED
            if (criteria.getEdnoInitial() != null) {
                predicates.add(criteriaBuilder.equal(root.get("ednoInitial"), criteria.getEdnoInitial()));
            }
            if (criteria.getEdDateInitial() != null) {
                predicates.add(criteriaBuilder.equal(root.get("edDateInitial"), criteria.getEdDateInitial()));
            }
            if (criteria.getEdAuthorInitial() != null) {
                predicates.add(criteriaBuilder.equal(root.get("edAuthorInitial"), criteria.getEdAuthorInitial()));
            }
            if (criteria.getImportDataInitialId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("importDataInitialId"), criteria.getImportDataInitialId()));
            }
            if (criteria.getCreationTimeInitial() != null) {
                predicates.add(criteriaBuilder.equal(root.get("creationTimeInitial"), criteria.getCreationTimeInitial()));
            }
            if (criteria.getChangeTimeInitial() != null) {
                predicates.add(criteriaBuilder.equal(root.get("changeTimeInitial"), criteria.getChangeTimeInitial()));
            }
            if (criteria.getDeleteTimeInitial() != null) {
                predicates.add(criteriaBuilder.equal(root.get("deleteTimeInitial"), criteria.getDeleteTimeInitial()));
            }

            // Поля BaseEntity
            predicates.addAll(BaseEntitySpecifications.byBaseCriteria(root, query, criteriaBuilder, criteria));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
