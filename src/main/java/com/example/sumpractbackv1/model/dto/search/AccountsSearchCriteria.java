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

    @Parameter(description = "Поиск по номеру счета")
    private String searchAccount;

    @Parameter(description = "Фильтр по типу счета")
    private RegulationAccountType regulationAccountType;

    @Parameter(description = "Поиск по контрольному ключу")
    private String searchCk;

    @Parameter(description = "Поиск по БИК ПБР, обслуживающего счет участника перевода")
    private String searchAccountCbrbic;
    
    @Parameter(description = "Поиск по дате открытия счета")
    private LocalDate fromDateInAccounts;

    @Parameter(description = "Поиск по дате открытия счета")
    private LocalDate toDateInAccounts;

    @Parameter(description = "Поиск по дате исключения информации о счете участника")
    private LocalDate fromDateOutAccounts;

    @Parameter(description = "Поиск по дате исключения информации о счете участника")
    private LocalDate toDateOutAccounts;

    @Parameter(description = "Фильтр по статусу счета")
    private AccountStatus accountStatus;

    @Parameter(description = "Фильтр по Id BicDirectoryEntry")
    @Positive(message = "Id BicDirectoryEntry должен быть больше нуля")
    private Long bicDirectoryEntryId;

}
