package com.example.sumpractbackv1.util.specifications;

import com.example.sumpractbackv1.model.dto.search.SwbicsSearchCriteria;
import com.example.sumpractbackv1.model.entity.Swbics;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class SwbicsSpecifications {

    public static Specification<Swbics> byCriteria(SwbicsSearchCriteria criteria) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Поля Swbics
            if (criteria.getSearchSwbic() != null && !criteria.getSearchSwbic().isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("swbic"),
                    StaticUtils.likePattern(criteria.getSearchSwbic())));
            }
            if (criteria.getDefaultSwbic() != null) {
                predicates.add(criteriaBuilder.equal(root.get("defaultSwbic"),
                    criteria.getDefaultSwbic()));
            }
            if (criteria.getBicDirectoryEntryId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("bicDirectoryEntry").get("id"),
                    criteria.getBicDirectoryEntryId()));
            }

            // Поля BaseEntity
            predicates.addAll(BaseEntitySpecifications.byBaseCriteria(root, query, criteriaBuilder, criteria));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
