package com.example.sumpractbackv1.util.specifications;

import com.example.sumpractbackv1.model.dto.search.AccountsSearchCriteria;
import com.example.sumpractbackv1.model.entity.Accounts;

import jakarta.persistence.criteria.Predicate;
import lombok.ToString;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

@ToString
public class AccountsSpecifications {

    public static Specification<Accounts> byCriteria(AccountsSearchCriteria criteria) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Поля Accounts
            if (criteria.getSearchAccount() != null && !criteria.getSearchAccount().isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("account"),
                    StaticUtils.likePattern(criteria.getSearchAccount())));
            }
            if (criteria.getRegulationAccountType() != null) {
                predicates.add(criteriaBuilder.equal(root.get("regulationAccountType"),
                    criteria.getRegulationAccountType()));
            }
            if (criteria.getSearchCk() != null && !criteria.getSearchCk().isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("ck"),
                    StaticUtils.likePattern(criteria.getSearchCk())));
            }
            if (criteria.getSearchAccountCbrbic() != null) {
                predicates.add(StaticUtils.likeBic(criteriaBuilder, root.get("accountCbrbic"),
                    criteria.getSearchAccountCbrbic()));
            }
            if (criteria.getFromDateInAccounts() != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("dateInAccounts"),
                    criteria.getFromDateInAccounts()));
            }
            if (criteria.getToDateInAccounts() != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("dateInAccounts"),
                    criteria.getToDateInAccounts()));
            }
            if (criteria.getFromDateOutAccounts() != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("dateOutAccounts"),
                    criteria.getFromDateOutAccounts()));
            }
            if (criteria.getToDateOutAccounts() != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("dateOutAccounts"),
                    criteria.getToDateOutAccounts()));
            }
            if (criteria.getAccountStatus() != null) {
                predicates.add(criteriaBuilder.equal(root.get("accountStatus"),
                    criteria.getAccountStatus()));
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