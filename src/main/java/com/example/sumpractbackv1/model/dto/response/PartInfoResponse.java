package com.example.sumpractbackv1.model.dto.response;

import com.example.sumpractbackv1.model.entity.PartInfo;

import lombok.*;

@Data
public class PartInfoResponse {

	private Integer partNo;

	private Integer partQuantity;

	private String partAggregateID;

	public PartInfoResponse(PartInfo partInfo) {
		this.partNo = partInfo.getPartNo();
		this.partQuantity = partInfo.getPartQuantity();
		this.partAggregateID = partInfo.getPartAggregateID();
	}
	
}
