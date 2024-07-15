package com.example.sumpractbackv1.model.dto.request;

import com.example.sumpractbackv1.model.enums.AccRstr;

import java.time.LocalDate;

public class AccRstrListRequest extends BaseEntityRequest {

    private AccRstr accRstr;

    private LocalDate accRstrDate;

    private Long successorBIC;

    private Long accounts;
}
