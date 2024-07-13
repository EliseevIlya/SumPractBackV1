package com.example.sumpractbackv1.model.dto.search;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.Parameter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BaseEntitySearchCriteria {

    private Long id;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
    private String createdBy;
    private String lastModifiedBy;
    @Parameter()
    private Boolean deleted = Boolean.FALSE;

}
