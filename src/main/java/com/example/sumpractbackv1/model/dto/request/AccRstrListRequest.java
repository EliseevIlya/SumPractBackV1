package com.example.sumpractbackv1.model.dto.request;

import com.example.sumpractbackv1.model.enums.AccRstr;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Schema(description = "класс для создания/изменение AccRstrList. Перечень ограничений операций по счету.")
public class AccRstrListRequest extends BaseEntityRequest {

    @Schema(description = "Код ограничения операций по счету.")
    @Size(min = 4, max = 4)
    @NotNull
    private AccRstr accRstr;

    @Schema(description = "Дата начала действия ограничения операций по счету.")
    @NotNull
    private LocalDate accRstrDate;

    @Schema(description = "БИК преемника. ")
    @Size(min = 9, max = 9)
    private Long successorBIC;

    @Schema(description = "Связь с родителем Accounts")
    private Long accounts;
}
