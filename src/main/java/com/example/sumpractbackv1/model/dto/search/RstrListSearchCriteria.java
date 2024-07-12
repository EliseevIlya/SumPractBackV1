package com.example.sumpractbackv1.model.dto.search;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RstrListSearchCriteria extends BaseEntitySearchCriteria {
    private String rstr;
    private LocalDate rstrDate;
    private Long participantInfoRstrListId;
}
