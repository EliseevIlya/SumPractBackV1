package com.example.sumpractbackv1.model.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PartInfoRequest extends BaseEntityRequest {

    private Integer partNo;

    private Integer partQuantity;

    private String partAggregateID;

    private Long importData;
}
