package com.example.sumpractbackv1.model.dto.request;

import com.example.sumpractbackv1.model.enums.AccountStatus;
import com.example.sumpractbackv1.model.enums.RegulationAccountType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;

@Schema(description = "класс для создания/изменение Accounts. Информация о счетах участника перевода денежных средств.")
public class AccountsRequest extends BaseEntityRequest {

    @Schema(description = "Номер счета.")
    @NotNull(message = "не может быть нулевым")
    @Max(value = 20, message = "длина не более 20 символов")
    private String account;

    @Schema(description = "Тип счета в соответствии с нормативом.")
    @NotNull
    @Size(min = 4, max = 4)
    private RegulationAccountType regulationAccountType;

    @Schema(description = "Контрольный ключ.")
    @Size(min = 2, max = 2)
    private String ck;

    @Schema(description = "БИК ПБР, обслуживающего счет участника перевода.")
    @NotNull
    @Size(min = 9, max = 9)
    private Long accountCbrbic;

    @Schema(description = "Дата открытия счета.")
    @NotNull
    private LocalDate dateIn;

    @Schema(description = "Дата исключения информации о счете участника.")
    private LocalDate dateOut;

    @Schema(description = "Статус счета.")
    private AccountStatus accountStatus;

    @Schema(description = "Связь с родителем BICDirectoryEntry")
    private Long bicDirectoryEntry;

    @Schema(description = "Связь с дочерним элементом AccRstrList")
    private List<Long> accRstrLists;

}
