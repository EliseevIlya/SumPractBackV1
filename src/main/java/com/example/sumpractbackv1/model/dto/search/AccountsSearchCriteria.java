package com.example.sumpractbackv1.model.dto.search;

import com.example.sumpractbackv1.model.enums.AccountStatus;
import com.example.sumpractbackv1.model.enums.RegulationAccountType;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.*;

import java.time.LocalDate;

import org.springdoc.core.annotations.ParameterObject;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ParameterObject
public class AccountsSearchCriteria extends BaseEntitySearchCriteria {
    @Parameter(description = "Account")
    private String account;
    private RegulationAccountType regulationAccountType;
    private String ck;
    private Long accountCbrbic;
    private LocalDate dateInAccounts;
    private LocalDate dateOutAccounts;
    private AccountStatus accountStatus;
}
