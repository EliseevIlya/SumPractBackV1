package com.example.sumpractbackv1.util.specifications;

import com.example.sumpractbackv1.model.dto.search.AccRstrListSearchCriteria;
import com.example.sumpractbackv1.model.entity.AccRstrList;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class AccRstrListSpecifications {

    public static Specification<AccRstrList> byCriteria(AccRstrListSearchCriteria criteria) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Поля AccRstrList
            if (criteria.getAccRstr() != null) {
                predicates.add(criteriaBuilder.equal(root.get("accRstr"),
                    criteria.getAccRstr()));
            }
            if (criteria.getFromAccRstrDate() != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("accRstrDate"),
                    criteria.getFromAccRstrDate()));
            }
            if (criteria.getToAccRstrDate() != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("accRstrDate"),
                    criteria.getToAccRstrDate()));
            }
            if (criteria.getSearchSuccessorBIC() != null) {
                predicates.add(StaticUtils.likeBic(criteriaBuilder, root.get("successorBIC"),
                    criteria.getSearchSuccessorBIC()));
            }
            if (criteria.getAccountsId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("accounts").get("id"),
                    criteria.getAccountsId()));
            }

            // Поля BaseEntity
            predicates.addAll(BaseEntitySpecifications.byBaseCriteria(root, query, criteriaBuilder, criteria));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}