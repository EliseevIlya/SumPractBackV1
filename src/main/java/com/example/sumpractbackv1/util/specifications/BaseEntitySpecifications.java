package com.example.sumpractbackv1.util.specifications;

import com.example.sumpractbackv1.model.dto.search.BaseEntitySearchCriteria;
import jakarta.persistence.criteria.Predicate;

import java.util.ArrayList;
import java.util.List;

public class BaseEntitySpecifications {

    public static <T> List<Predicate> byBaseCriteria(jakarta.persistence.criteria.Root<T> root, jakarta.persistence.criteria.CriteriaQuery<?> query, jakarta.persistence.criteria.CriteriaBuilder criteriaBuilder, BaseEntitySearchCriteria criteria) {
        List<Predicate> predicates = new ArrayList<>();

        if (criteria.getId() != null) {
            predicates.add(criteriaBuilder.equal(root.get("id"), criteria.getId()));
        }
        if (criteria.getFromCreatedDate() != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("createdDate"),
                    criteria.getFromCreatedDate()));
        }
        if (criteria.getToCreatedDate() != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("createdDate"),
                    criteria.getToCreatedDate()));
        }
        if (criteria.getFromLastModifiedDate() != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("lastModifiedDate"),
                    criteria.getFromLastModifiedDate()));
        }
        if (criteria.getToLastModifiedDate() != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("lastModifiedDate"),
                    criteria.getToLastModifiedDate()));
        }
        if (criteria.getCreatedBy() != null && !criteria.getCreatedBy().isEmpty()) {
            predicates.add(criteriaBuilder.equal(root.get("createdBy"), criteria.getCreatedBy()));
        }
        if (criteria.getLastModifiedBy() != null && !criteria.getLastModifiedBy().isEmpty()) {
            predicates.add(criteriaBuilder.equal(root.get("lastModifiedBy"), criteria.getLastModifiedBy()));
        }
        if (!criteria.getIncludeDeleted()) {
            predicates.add(criteriaBuilder.equal(root.get("deleted"), false));
        }

        return predicates;
    }
}