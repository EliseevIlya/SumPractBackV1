package com.example.sumpractbackv1.model.dto.search;

import com.example.sumpractbackv1.model.enums.AccountStatus;
import com.example.sumpractbackv1.model.enums.RegulationAccountType;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.*;
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

    @Parameter(description = "Параметр для поиска счета")
    private String searchAccount;

    @Parameter(description = "Тип счета")
    private RegulationAccountType regulationAccountType;

    @Parameter(description = "Параметр для поиска по контрольному ключу")
    private String searchCk;

    @Parameter(description = "Параметр для поиска по БИК ПБР, обслуживающего счет участника перевода")
    private String searchAccountCbrbic;
    
    @Parameter(description = "Фильтрация по дате открытия счета")
    private LocalDate fromDateInAccounts;

    @Parameter(description = "Фильтрация по дате открытия счета")
    private LocalDate toDateInAccounts;

    @Parameter(description = "Фильтрация по дате исключения информации о счете участника")
    private LocalDate fromDateOutAccounts;

    @Parameter(description = "Фильтрация по дате исключения информации о счете участника")
    private LocalDate toDateOutAccounts;

    @Parameter(description = "Статус счета")
    private AccountStatus accountStatus;

    @Parameter(description = "Id BICDirectoryEntry")
    @Positive(message = "Id BICDirectoryEntry должен быть больше нуля")
    private Long bicDirectoryEntryId;

}
