package com.example.sumpractbackv1.model.dto.search;

import com.example.sumpractbackv1.model.enums.AccRstr;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccRstrListSearchCriteria extends BaseEntitySearchCriteria {
    private AccRstr accRstr;
    private LocalDate accRstrDate;
    private Long successorBIC;
    private Long accountsId;
}
