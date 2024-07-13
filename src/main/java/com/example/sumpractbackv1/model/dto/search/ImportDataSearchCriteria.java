package com.example.sumpractbackv1.model.dto.search;

import com.example.sumpractbackv1.model.enums.CreationReason;
import com.example.sumpractbackv1.model.enums.InfoTypeCode;
import lombok.*;

import java.time.LocalDate;
import java.time.ZonedDateTime;

import org.springdoc.core.annotations.ParameterObject;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ParameterObject
public class ImportDataSearchCriteria extends BaseEntitySearchCriteria {
    private String xmlns;
    private Long edno;
    private LocalDate edDate;
    private Long edAuthor;
    private Long edReceiver;
    private CreationReason creationReason;
    private ZonedDateTime creationDateTime;
    private InfoTypeCode infoTypeCode;
    private LocalDate businessDay;
    private Integer directoryVersion;
}
