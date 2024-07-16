package com.example.sumpractbackv1.model.dto.request;

import com.example.sumpractbackv1.model.enums.Rstr;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class RstrListRequest extends BaseEntityRequest{

    private Rstr rstr;

    private LocalDate rstrDate;

    private Long participantInfo;
}
