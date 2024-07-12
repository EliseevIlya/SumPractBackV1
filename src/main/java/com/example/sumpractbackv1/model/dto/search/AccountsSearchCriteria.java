package com.example.sumpractbackv1.model.dto.search;

import com.example.sumpractbackv1.model.enums.AccountStatus;
import com.example.sumpractbackv1.model.enums.RegulationAccountType;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccountsSearchCriteria extends BaseEntitySearchCriteria {

    private String account;
    private RegulationAccountType regulationAccountType;
    private String ck;
    private Long accountCbrbic;
    private LocalDate dateInAccounts;
    private LocalDate dateOutAccounts;
    private AccountStatus accountStatus;
}
