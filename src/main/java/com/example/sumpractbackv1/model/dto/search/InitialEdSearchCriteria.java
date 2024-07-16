package com.example.sumpractbackv1.model.dto.search;

import lombok.*;

import java.time.LocalDate;

import org.springdoc.core.annotations.ParameterObject;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.Positive;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ParameterObject
public class InitialEdSearchCriteria extends BaseEntitySearchCriteria {

    @Parameter(description = "Поиск по номеру ЭС в течение опердня")
    private String searchEdno;

    @Parameter(description = "Поиск по дате составления ЭС")
    private LocalDate fromEdDate;

    @Parameter(description = "Поиск по дате составления ЭС")
    private LocalDate toEdDate;

    @Parameter(description = "Фильтр по уникальному идентификатору составителя ЭС - УИС")
    private String searchEdAuthor;

    @Parameter(description = "Фильтр по Id ImportData")
    @Positive(message = "Id ImportData должен быть больше нуля")
    private Long importDataId;

}
