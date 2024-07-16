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

@Schema(description = "класс для создания/изменение аккаунтов")
@Getter
@Setter
public class AccountsRequest extends BaseEntityRequest {

    @Schema(description = "номер счета")
    @NotEmpty
    @Size(max = 20)
    private String account;

    @Schema(description = "")
    @NotNull
    private RegulationAccountType regulationAccountType;

    @Schema(description = "")
    @Size(max = 2)
    private String ck;

    @Schema(description = "")
    @NotNull
    @Max(999999999L)
    @PositiveOrZero
    private Long accountCbrbic;

    @Schema(description = "")
    @NotNull
    private LocalDate dateIn;

    @Schema(description = "")
    private LocalDate dateOut;

    @Schema(description = "")
    private AccountStatus accountStatus;

    @Schema(description = "")
    @PositiveOrZero
    private Long bicDirectoryEntry;

    @Schema(description = "")
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
