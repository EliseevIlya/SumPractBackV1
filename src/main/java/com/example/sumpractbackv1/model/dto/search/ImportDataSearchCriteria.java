package com.example.sumpractbackv1.model.dto.search;

import com.example.sumpractbackv1.model.enums.CreationReason;
import com.example.sumpractbackv1.model.enums.InfoTypeCode;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.*;

import java.time.LocalDate;
import java.time.ZonedDateTime;

import org.springdoc.core.annotations.ParameterObject;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ParameterObject
public class ImportDataSearchCriteria extends BaseEntitySearchCriteria {

    @Parameter(description = "Фильтр по формату")
    private String xmlns;

    @Parameter(description = "Поиск по номеру ЭС в течение опердня")
    private String searchEdno;

    @Parameter(description = "Поиск по Уникальному идентификатору составителя ЭС - УИС")
    private String searchEdAuthor;

    @Parameter(description = "Поиск по Уникальному идентификатору получателя ЭС")
    private String searchEdReceiver;

    @Parameter(description = "Фильтр по виду запроса информации")
    private CreationReason creationReason;

    @Parameter(description = "Поиск по дате и времени создания ЭС")
    private ZonedDateTime fromCreationDateTime;

    @Parameter(description = "Поиск по дате и времени создания ЭС")
    private ZonedDateTime toCreationDateTime;

    @Parameter(description = "Фильтр по виду представления информации")
    private InfoTypeCode infoTypeCode;

    @Parameter(description = "Фильтр по дате ОД, к которой относятся данные Справочника БИК")
    private LocalDate businessDay;

    @Parameter(description = "Фильтр по версии Справочника БИК в течение операционного дня")
    private Integer directoryVersion;
}
