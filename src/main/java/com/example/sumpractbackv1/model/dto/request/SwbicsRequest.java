package com.example.sumpractbackv1.model.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SwbicsRequest extends BaseEntityRequest {

    private String swbic;

    private Integer defaultSwbic;

    private Long bicDirectoryEntry;
}
