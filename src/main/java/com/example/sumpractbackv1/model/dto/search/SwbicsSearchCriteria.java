package com.example.sumpractbackv1.model.dto.search;


import org.springdoc.core.annotations.ParameterObject;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ParameterObject
public class SwbicsSearchCriteria extends BaseEntitySearchCriteria {

    @Parameter(description = "Поиск по БИК (СВИФТ)")
    private String searchSwbic;

    @Parameter(description = "Фильтр по признаку использования БИК (СВИФТ), \"по умолчанию\"")
    private Integer defaultSwbic;

    @Parameter(description = "Фильтр по Id BicDirectoryEntry")
    @Positive(message = "Id BicDirectoryEntry должен быть больше нуля")
    private Long bicDirectoryEntryId;
}
