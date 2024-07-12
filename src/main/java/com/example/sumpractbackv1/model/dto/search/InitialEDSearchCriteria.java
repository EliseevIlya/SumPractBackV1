package com.example.sumpractbackv1.model.dto.search;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InitialEDSearchCriteria extends BaseEntitySearchCriteria {
    private Long ednoInitial;
    private LocalDate edDateInitial;
    private Long edAuthorInitial;
    private Long importDataInitialId;
    private LocalDate creationTimeInitial;
    private LocalDate changeTimeInitial;
    private LocalDate deleteTimeInitial;
}
