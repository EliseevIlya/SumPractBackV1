package com.example.sumpractbackv1.model.dto.search;

import com.example.sumpractbackv1.model.enums.AccRstr;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.springdoc.core.annotations.ParameterObject;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ParameterObject
public class AccRstrListSearchCriteria extends BaseEntitySearchCriteria {

    @Parameter(description = "Фильтр по коду ограничений операций по счету")
    private AccRstr accRstr;

    @Parameter(description = "Поиск по дате начала действия ограничения операций по счету")
    private LocalDate fromAccRstrDate;

    @Parameter(description = "Поиск по дате начала действия ограничения операций по счету")
    private LocalDate toAccRstrDate;

    @Parameter(description = "Поиск по БИК преемника")
    private String searchSuccessorBIC;

    @Parameter(description = "Фильтр по Id Accounts")
    @Positive(message = "Id Accounts должен быть больше нуля")
    private Long accountsId;
}
