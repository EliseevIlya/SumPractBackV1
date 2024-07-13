package com.example.sumpractbackv1.model.dto.search;

import lombok.*;

import java.time.LocalDate;

import org.springdoc.core.annotations.ParameterObject;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ParameterObject
public class RstrListSearchCriteria extends BaseEntitySearchCriteria {
    private String rstr;
    private LocalDate rstrDate;
    private Long participantInfoRstrListId;
}
