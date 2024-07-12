package com.example.sumpractbackv1.util.specifications;

import com.example.sumpractbackv1.model.dto.search.PartInfoSearchCriteria;
import com.example.sumpractbackv1.model.entity.PartInfo;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class PartInfoSpecifications {

    public static Specification<PartInfo> byCriteria(PartInfoSearchCriteria criteria) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Поля PartInfo
            if (criteria.getPartNo() != null) {
                predicates.add(criteriaBuilder.equal(root.get("partNo"), criteria.getPartNo()));
            }
            if (criteria.getPartQuantity() != null) {
                predicates.add(criteriaBuilder.equal(root.get("partQuantity"), criteria.getPartQuantity()));
            }
            if (criteria.getPartAggregateID() != null && !criteria.getPartAggregateID().isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("partAggregateID"), criteria.getPartAggregateID()));
            }
            if (criteria.getImportDataPartInfoId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("importDataPartInfoId"), criteria.getImportDataPartInfoId()));
            }

            // Поля BaseEntity
            predicates.addAll(BaseEntitySpecifications.byBaseCriteria(root, query, criteriaBuilder, criteria));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}