package com.example.sumpractbackv1.model.dto.search;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.springdoc.core.annotations.ParameterObject;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ParameterObject
public class PartInfoSearchCriteria extends BaseEntitySearchCriteria {

    @Parameter(description = "Фильтр по номеру части")
    private Integer partNo;

    @Parameter(description = "Фильтр по количеству частей")
    private Integer partQuantity;

    @Parameter(description = "Поиск по уникальному идентификатору совокупности частей")
    private String searchPartAggregateID;

    @Parameter(description = "Фильтр по Id ImportData")
    @Positive(message = "Id ImportData должен быть больше нуля")
    private Long importDataId;
}
