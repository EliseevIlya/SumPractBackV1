package com.example.sumpractbackv1.model.dto.request;

import com.example.sumpractbackv1.model.entity.AccRstrList;
import com.example.sumpractbackv1.model.enums.AccRstr;

import lombok.Getter;
import lombok.Setter;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Getter
@Setter
@Schema(description = "класс для создания/изменение AccRstrList. Перечень ограничений операций по счету.")
public class AccRstrListRequest extends BaseEntityRequest {

    @Schema(description = "Код ограничения операций по счету.")
    @NotNull
    private AccRstr accRstr;

    @Schema(description = "Дата начала действия ограничения операций по счету.")
    @NotNull
    private LocalDate accRstrDate;

    @Schema(description = "БИК преемника. ")
    @Size(min = 9, max = 9)
    private Long successorBIC;

    @Schema(description = "Связь с родителем Accounts")
    @Positive
    private Long accounts;

    public AccRstrList toAccRstrList() {
        var accRstrList = AccRstrList.builder()
                .accRstr(accRstr)
                .accRstrDate(accRstrDate)
                .successorBIC(successorBIC)
                .build();
        accRstrList.setId(getId());
        return accRstrList;
    }

}
