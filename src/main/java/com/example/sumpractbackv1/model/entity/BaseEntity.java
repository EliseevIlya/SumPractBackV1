package com.example.sumpractbackv1.model.entity;

import java.time.ZonedDateTime;

import org.springframework.data.annotation.*;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity {

    @CreatedDate
    private ZonedDateTime createdDate;
    
    @LastModifiedDate
    private ZonedDateTime lastModifiedDate;

	@CreatedBy
    private String createdBy;
    
    @LastModifiedBy
    private String lastModifiedBy;
	
}
