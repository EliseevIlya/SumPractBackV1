package com.example.sumpractbackv1.model.dto.search;

import com.example.sumpractbackv1.model.enums.AccRstr;

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
public class AccRstrListSearchCriteria extends BaseEntitySearchCriteria {

    @Parameter(description = "Код ограничений операций по счету")
    private AccRstr accRstr;

    @Parameter(description = "Параметр для поиска даты начала действия ограничения операций по счету")
    private LocalDate fromAccRstrDate;

    @Parameter(description = "Параметр для поиска даты начала действия ограничения операций по счету")
    private LocalDate toAccRstrDate;

    @Parameter(description = "БИК преемника")
    @Digits(integer = 9, fraction = 0)
    private String searchSuccessorBIC;

    @Parameter(description = "Id Accounts")
    @Positive(message = "Id Accounts должен быть больше нуля")
    private Long accountsId;
}
