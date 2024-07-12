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
        if (criteria.getCreatedDate() != null) {
            predicates.add(criteriaBuilder.equal(root.get("createdDate"), criteria.getCreatedDate()));
        }
        if (criteria.getLastModifiedDate() != null) {
            predicates.add(criteriaBuilder.equal(root.get("lastModifiedDate"), criteria.getLastModifiedDate()));
        }
        if (criteria.getCreatedBy() != null && !criteria.getCreatedBy().isEmpty()) {
            predicates.add(criteriaBuilder.equal(root.get("createdBy"), criteria.getCreatedBy()));
        }
        if (criteria.getLastModifiedBy() != null && !criteria.getLastModifiedBy().isEmpty()) {
            predicates.add(criteriaBuilder.equal(root.get("lastModifiedBy"), criteria.getLastModifiedBy()));
        }
        if (criteria.getDeleted() != null) {
            predicates.add(criteriaBuilder.equal(root.get("deleted"), criteria.getDeleted()));
        }

        return predicates;
    }
}