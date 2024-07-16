package com.example.sumpractbackv1.model.dto.search;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.Parameter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BaseEntitySearchCriteria {

    @Parameter(description = "Фильтр по идентификатору")
    private Long id;

    @Parameter(description = "Параметр для поиска по дате создания")
    private LocalDateTime fromCreatedDate;

    @Parameter(description = "Параметр для поиска по дате создания")
    private LocalDateTime toCreatedDate;

    @Parameter(description = "Параметр для поиска по дате изменения")
    private LocalDateTime fromLastModifiedDate;

    @Parameter(description = "Параметр для поиска по дате изменения")
    private LocalDateTime toLastModifiedDate;

    @Parameter(description = "Параметр для поиска по имени создателя")
    private String createdBy;

    @Parameter(description = "Параметр для поиска по имени изменявшего")
    private String lastModifiedBy;
    
    @Parameter(description = "Флаг, показывающий нужно ли включать удаленные сущности")
    private Boolean includeDeleted = Boolean.FALSE;

}
