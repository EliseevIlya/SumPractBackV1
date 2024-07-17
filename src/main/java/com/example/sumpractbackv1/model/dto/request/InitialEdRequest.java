package com.example.sumpractbackv1.model.dto.request;


import java.time.LocalDate;

import com.example.sumpractbackv1.model.entity.InitialEd;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InitialEdRequest extends BaseEntityRequest {

    private Long edno;

    private LocalDate edDate;

    private Long edAuthor;

    private Long importData;

    public InitialEd toInitialEd() {
        var initialEd = InitialEd.builder()
            .edno(edno)
            .edDate(edDate)
            .edAuthor(edAuthor)
            .build();
        initialEd.setId(getId());
        return initialEd;
    }

}
