package com.example.sumpractbackv1.model.dto.request;

import com.example.sumpractbackv1.model.enums.AccRstr;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AccRstrListRequest extends BaseEntityRequest {

    private AccRstr accRstr;

    private LocalDate accRstrDate;

    private Long successorBIC;

    private Long accounts;
}
