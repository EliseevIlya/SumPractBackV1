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
            if (criteria.getAccount() != null && !criteria.getAccount().isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("account"), criteria.getAccount()));
            }
            if (criteria.getRegulationAccountType() != null) {
                predicates.add(criteriaBuilder.equal(root.get("regulationAccountType"), criteria.getRegulationAccountType()));
            }
            if (criteria.getCk() != null && !criteria.getCk().isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("ck"), criteria.getCk()));
            }
            if (criteria.getAccountCbrbic() != null) {
                predicates.add(criteriaBuilder.equal(root.get("accountCbrbic"), criteria.getAccountCbrbic()));
            }
            if (criteria.getDateInAccounts() != null) {
                predicates.add(criteriaBuilder.equal(root.get("dateInAccounts"), criteria.getDateInAccounts()));
            }
            if (criteria.getDateOutAccounts() != null) {
                predicates.add(criteriaBuilder.equal(root.get("dateOutAccounts"), criteria.getDateOutAccounts()));
            }
            if (criteria.getAccountStatus() != null) {
                predicates.add(criteriaBuilder.equal(root.get("accountStatus"), criteria.getAccountStatus()));
            }

            // Поля BaseEntity
            predicates.addAll(BaseEntitySpecifications.byBaseCriteria(root, query, criteriaBuilder, criteria));


            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}