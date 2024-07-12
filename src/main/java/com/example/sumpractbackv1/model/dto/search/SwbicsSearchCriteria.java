package com.example.sumpractbackv1.model.dto.search;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SwbicsSearchCriteria extends BaseEntitySearchCriteria {
    private String swbic;
    private Integer defaultSwbic;
    private Long bicSwibcsId;
}
