package com.example.sumpractbackv1.model.dto.search;

import com.example.sumpractbackv1.model.enums.Rstr;
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
public class RstrListSearchCriteria extends BaseEntitySearchCriteria {

    @Parameter(description = "Фильтр по коду ограничения, наложенного на участника")
    private Rstr rstr;

    @Parameter(description = "Поиск по дате начала действия ограничения участника")
    private LocalDate fromRstrDate;

    @Parameter(description = "Поиск по дате начала действия ограничения участника")
    private LocalDate toRstrDate;

    @Parameter(description = "Фильтр по Id ParticipantInfo")
    @Positive(message = "Id ParticipantInfo должен быть больше нуля")
    private Long participantInfoId;
}
