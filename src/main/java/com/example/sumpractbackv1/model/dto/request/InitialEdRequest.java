package com.example.sumpractbackv1.model.dto.request;


import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InitialEdRequest extends BaseEntityRequest {

    private Long edno;

    private LocalDate edDate;

    private Long edAuthor;

    private Long importData;


}
