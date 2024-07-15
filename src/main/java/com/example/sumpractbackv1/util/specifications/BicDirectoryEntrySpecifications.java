package com.example.sumpractbackv1.util.specifications;

import com.example.sumpractbackv1.model.dto.search.BicDirectoryEntrySearchCriteria;
import com.example.sumpractbackv1.model.entity.BICDirectoryEntry;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class BicDirectoryEntrySpecifications {

    public static Specification<BICDirectoryEntry> byCriteria(BicDirectoryEntrySearchCriteria criteria) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Поля BICDirectoryEntry
            if (criteria.getBic() != null) {
                predicates.add(criteriaBuilder.equal(root.get("bic"), criteria.getBic()));
            }
            if (criteria.getChangeType() != null) {
                predicates.add(criteriaBuilder.equal(root.get("changeType"), criteria.getChangeType()));
            }
            if (criteria.getImportDataBicId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("importDataBicId").get("id"), criteria.getImportDataBicId()));
            }

            // Поля BaseEntity
            predicates.addAll(BaseEntitySpecifications.byBaseCriteria(root, query, criteriaBuilder, criteria));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
