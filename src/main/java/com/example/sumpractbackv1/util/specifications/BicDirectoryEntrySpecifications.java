package com.example.sumpractbackv1.util.specifications;

import com.example.sumpractbackv1.model.dto.search.BicDirectoryEntrySearchCriteria;
import com.example.sumpractbackv1.model.entity.BicDirectoryEntry;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class BicDirectoryEntrySpecifications {

    public static Specification<BicDirectoryEntry> byCriteria(BicDirectoryEntrySearchCriteria criteria) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Поля BICDirectoryEntry
            if (criteria.getSearchBic() != null) {
                predicates.add(StaticUtils.likeBic(criteriaBuilder, root.get("bic"),
                    criteria.getSearchBic()));
            }
            if (criteria.getChangeType() != null) {
                predicates.add(criteriaBuilder.equal(root.get("changeType"),
                    criteria.getChangeType()));
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
