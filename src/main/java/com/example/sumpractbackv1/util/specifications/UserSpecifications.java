package com.example.sumpractbackv1.util.specifications;

import com.example.sumpractbackv1.model.dto.search.UserSearchCriteria;
import com.example.sumpractbackv1.model.entity.User;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class UserSpecifications {

    public static Specification<User> byCriteria(UserSearchCriteria criteria) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (criteria.getId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("id"), criteria.getId()));
            }
            if (criteria.getUsername() != null && !criteria.getUsername().isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("username"), criteria.getUsername()));
            }
            if (criteria.getRole() != null) {
                predicates.add(criteriaBuilder.equal(root.get("role"), criteria.getRole()));
            }
            if (criteria.getCreatedAt() != null) {
                predicates.add(criteriaBuilder.equal(root.get("createdAt"), criteria.getCreatedAt()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}