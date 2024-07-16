package com.example.sumpractbackv1.model.dto.search;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.time.LocalDateTime;

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

    @Parameter(description = "номер страницы")
    @PositiveOrZero()
    private Integer page = 0;

    @Parameter(description = "количество отоброжаемых элементов")
    @Positive()
    private Integer size = 10;

}
