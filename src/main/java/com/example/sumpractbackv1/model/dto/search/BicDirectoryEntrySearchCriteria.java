package com.example.sumpractbackv1.model.dto.search;

import com.example.sumpractbackv1.model.enums.ChangeType;
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
public class BicDirectoryEntrySearchCriteria extends BaseEntitySearchCriteria {

    @Parameter(description = "Поиск по БИК")
    private String searchBic;

    @Parameter(description = "Фильтр по типу изменения в Справочнике по сравнению с предыдущей версией справочника")
    private ChangeType changeType;

    @Parameter(description = "Фильтр по Id ImportData")
    @Positive(message = "Id ImportData должен быть больше нуля")
    private Long importDataId;
}
