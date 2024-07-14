package com.example.sumpractbackv1.model.dto.response;

import java.time.LocalDateTime;

import com.example.sumpractbackv1.model.entity.BaseEntity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@ToString
@Schema(name = "BaseEntity", description = "Базовая сущность")
public class BaseEntityResponse {
	
	private Long id;

	private LocalDateTime createdDate;

	private LocalDateTime lastModifiedDate;

	private String createdBy;

	private String lastModifiedBy;

	private Boolean deleted;

	public BaseEntityResponse(BaseEntity entity) {
		this.id = entity.getId();
		this.createdDate = entity.getCreatedDate();
		this.lastModifiedDate = entity.getLastModifiedDate();
		this.createdBy = entity.getCreatedBy();
		this.lastModifiedBy = entity.getLastModifiedBy();
		this.deleted = entity.getDeleted();
	}

}
