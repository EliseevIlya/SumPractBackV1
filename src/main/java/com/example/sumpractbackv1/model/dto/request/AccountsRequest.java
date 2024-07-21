package com.example.sumpractbackv1.model.dto.request;

import com.example.sumpractbackv1.model.entity.Accounts;
import com.example.sumpractbackv1.model.enums.AccountStatus;
import com.example.sumpractbackv1.model.enums.RegulationAccountType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Schema(description = "класс для создания/изменение Accounts. Информация о счетах участника перевода денежных средств.")
@Getter
@Setter
public class AccountsRequest extends BaseEntityRequest {

    @Schema(description = "Номер счета.")
    @NotEmpty
    @Size(max = 20)
    private String account;

    @Schema(description = "Тип счета в соответствии с нормативом.")
    @NotNull
    private RegulationAccountType regulationAccountType;

    @Schema(description = "Контрольный ключ.")
    @Size(max = 2)
    private String ck;

    @Schema(description = "БИК ПБР, обслуживающего счет участника перевода.")
    @NotNull
    @Max(999999999L)
    @PositiveOrZero
    private Long accountCbrbic;

    @Schema(description = "Дата открытия счета.")
    @NotNull
    private LocalDate dateIn;

    @Schema(description = "Дата исключения информации о счете участника.")
    private LocalDate dateOut;

    @Schema(description = "Статус счета.")
    private AccountStatus accountStatus;

    @Schema(description = "Связь с родителем BICDirectoryEntry")
    @PositiveOrZero
    private Long bicDirectoryEntry;

    @Schema(description = "Связь с дочерним элементом AccRstrList")
    private List<Long> accRstrLists = List.of();

    public Accounts toAccounts() {
        var accounts = Accounts.builder()
                .account(account)
                .regulationAccountType(regulationAccountType)
                .ck(ck)
                .accountCbrbic(accountCbrbic)
                .dateIn(dateIn)
                .dateOut(dateOut)
                .accountStatus(accountStatus)
                .build();
        System.out.println(getId());
        accounts.setId(getId());
        return accounts;
    }

}
