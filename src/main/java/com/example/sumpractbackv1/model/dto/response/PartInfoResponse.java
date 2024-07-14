package com.example.sumpractbackv1.model.dto.response;

import com.example.sumpractbackv1.model.entity.PartInfo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@ToString
@Schema(name = "PartInfo")
public class PartInfoResponse extends BaseEntityResponse {

	private Integer partNo;

	private Integer partQuantity;

	private String partAggregateID;

	public PartInfoResponse(PartInfo partInfo) {
		super(partInfo);
		this.partNo = partInfo.getPartNo();
		this.partQuantity = partInfo.getPartQuantity();
		this.partAggregateID = partInfo.getPartAggregateID();
	}
	
}
