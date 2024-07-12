package com.example.sumpractbackv1.model.dto.search;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PartInfoSearchCriteria extends BaseEntitySearchCriteria {
    private Integer partNo;
    private Integer partQuantity;
    private String partAggregateID;
    private Long importDataPartInfoId;
}
