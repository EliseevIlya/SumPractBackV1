package com.example.sumpractbackv1.model.dto.search;


import org.springdoc.core.annotations.ParameterObject;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ParameterObject
public class SwbicsSearchCriteria extends BaseEntitySearchCriteria {
    private String swbic;
    private Integer defaultSwbic;
    private Long bicSwibcsId;
}
