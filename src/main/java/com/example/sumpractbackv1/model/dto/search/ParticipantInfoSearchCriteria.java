package com.example.sumpractbackv1.model.dto.search;

import com.example.sumpractbackv1.model.enums.ParticipantStatus;
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
public class ParticipantInfoSearchCriteria extends BaseEntitySearchCriteria {

    @Parameter(description = "Поиск по наименование участника")
    private String searchNameP;

    @Parameter(description = "Поиск по наименование участника на английском языке")
    private String searchEnglName;

    @Parameter(description = "Поиск по регистрационному порядковому номеру")
    private String searchRegN;

    @Parameter(description = "Фильтр по коду страны")
    private String cntrCd;

    @Parameter(description = "Фильтр по коду территории")
    private String rgn;

    @Parameter(description = "Фильтр по индексу")
    private String ind;

    @Parameter(description = "Фильтр по типу населенного пункта")
    private String tnp;

    @Parameter(description = "Поиск по наименованию населенного пункта")
    private String searchNnp;

    @Parameter(description = "Поиск по адресу")
    private String searchAdr;

    @Parameter(description = "Поиск по BIC головной организации")
    private String searchPrntBIC;

    @Parameter(description = "Поиск по дате включения в состав участников перевода")
    private LocalDate fromDateInParticipant;

    @Parameter(description = "Поиск по дате исключения из состава участников перевода")
    private LocalDate toDateOutParticipant;

    @Parameter(description = "Поиск по дате исключения информации об участнике")
    private LocalDate fromDateOutParticipant;

    @Parameter(description = "Поиск по дате включения информации об участнике")
    private LocalDate toDateInParticipant;

    @Parameter(description = "Фильтр по типу участника перевода")
    private String ptType;

    @Parameter(description = "Фильтр по доступным сервисам перевода денежных средств")
    private String srvcs;

    @Parameter(description = "Фильтр по типу участника обмена")
    private String xchType;

    @Parameter(description = "Фильтр по УИС")
    private Long uid;

    @Parameter(description = "Фильтр по статусу участника")
    private ParticipantStatus participantStatus;

    @Parameter(description = "Фильтр по Id ImportData")
    @Positive(message = "Id ImportData должен быть больше нуля")
    private Long bicDirectoryEntryId;
}
