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
            if (criteria.getSearchEdno() != null) {
                predicates.add(StaticUtils.likeBic(criteriaBuilder, root.get("edno"),
                    criteria.getSearchEdno()));
            }
            if (criteria.getFromEdDate() != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("edDate"),
                    criteria.getFromEdDate()));
            }
            if (criteria.getToEdDate() != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("edDate"),
                    criteria.getToEdDate()));
            }
            if (criteria.getSearchEdAuthor() != null) {
                predicates.add(StaticUtils.likeTenD(criteriaBuilder, root.get("edAuthor"),
                    criteria.getSearchEdAuthor()));
            }
            if (criteria.getImportDataId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("importData").get("id"),
                    criteria.getImportDataId()));
            }

            // Поля BaseEntity
            predicates.addAll(BaseEntitySpecifications.byBaseCriteria(root, query, criteriaBuilder, criteria));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
