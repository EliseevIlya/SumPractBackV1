package com.example.sumpractbackv1.model.dto.search;

import org.springdoc.core.annotations.ParameterObject;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ParameterObject
public class PartInfoSearchCriteria extends BaseEntitySearchCriteria {
    private Integer partNo;
    private Integer partQuantity;
    private String partAggregateID;
    private Long importDataPartInfoId;
}
