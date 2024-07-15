package com.example.sumpractbackv1.model.dto.request;

import com.example.sumpractbackv1.model.enums.AccountStatus;
import com.example.sumpractbackv1.model.enums.RegulationAccountType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

@Schema(description = "класс для создания/изменение аккаунтов")
public class AccountsRequest extends BaseEntityRequest {

    @Schema(description = "номер счета")
    @NotNull(message = "не может быть нулевым")
    @Max(value = 20,message = "длина не более 20 символов")
    private String account;

    @Schema(description = "")
    @NotNull
    @Max(4)
    private RegulationAccountType regulationAccountType;

    @Schema(description = "")
    @Max(2)
    private String ck;

    @Schema(description = "")
    @NotNull
    @Max(9)
    private Long accountCbrbic;

    @Schema(description = "")
    @NotNull
    private LocalDate dateIn;

    @Schema(description = "HUINY")
    private LocalDate dateOut;

    @Schema(description = "")
    private AccountStatus accountStatus;

    @Schema(description = "i ipal ety vashi svyzi")
    private Long bicDirectoryEntry;

    @Schema(description = "")
    private List<Long> accRstrLists;

}
