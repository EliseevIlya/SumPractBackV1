package com.example.sumpractbackv1.model.dto.request;

import com.example.sumpractbackv1.model.entity.PartInfo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PartInfoRequest extends BaseEntityRequest {

    private Integer partNo;

    private Integer partQuantity;

    private String partAggregateID;

    private Long importData;

    public PartInfo toPartInfo() {
        PartInfo partInfo = PartInfo.builder()
            .partNo(partNo)
            .partQuantity(partQuantity)
            .partAggregateID(partAggregateID)
            .build();
        partInfo.setId(getId());
        return partInfo;
    }

}
