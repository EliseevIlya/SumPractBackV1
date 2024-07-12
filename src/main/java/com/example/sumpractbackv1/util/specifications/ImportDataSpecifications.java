package com.example.sumpractbackv1.util.specifications;

import com.example.sumpractbackv1.model.dto.search.ImportDataSearchCriteria;
import com.example.sumpractbackv1.model.entity.ImportData;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class ImportDataSpecifications {

    public static Specification<ImportData> byCriteria(ImportDataSearchCriteria criteria) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Поля ImportData
            if (criteria.getXmlns() != null && !criteria.getXmlns().isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("xmlns"), criteria.getXmlns()));
            }
            if (criteria.getEdno() != null) {
                predicates.add(criteriaBuilder.equal(root.get("edno"), criteria.getEdno()));
            }
            if (criteria.getEdDate() != null) {
                predicates.add(criteriaBuilder.equal(root.get("edDate"), criteria.getEdDate()));
            }
            if (criteria.getEdAuthor() != null) {
                predicates.add(criteriaBuilder.equal(root.get("edAuthor"), criteria.getEdAuthor()));
            }
            if (criteria.getEdReceiver() != null) {
                predicates.add(criteriaBuilder.equal(root.get("edReceiver"), criteria.getEdReceiver()));
            }
            if (criteria.getCreationReason() != null) {
                predicates.add(criteriaBuilder.equal(root.get("creationReason"), criteria.getCreationReason()));
            }
            if (criteria.getCreationDateTime() != null) {
                predicates.add(criteriaBuilder.equal(root.get("creationDateTime"), criteria.getCreationDateTime()));
            }
            if (criteria.getInfoTypeCode() != null) {
                predicates.add(criteriaBuilder.equal(root.get("infoTypeCode"), criteria.getInfoTypeCode()));
            }
            if (criteria.getBusinessDay() != null) {
                predicates.add(criteriaBuilder.equal(root.get("businessDay"), criteria.getBusinessDay()));
            }
            if (criteria.getDirectoryVersion() != null) {
                predicates.add(criteriaBuilder.equal(root.get("directoryVersion"), criteria.getDirectoryVersion()));
            }

            // Поля BaseEntity
            predicates.addAll(BaseEntitySpecifications.byBaseCriteria(root, query, criteriaBuilder, criteria));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}