package com.example.sumpractbackv1.model.dto.request;

import com.example.sumpractbackv1.model.enums.CreationReason;
import com.example.sumpractbackv1.model.enums.InfoTypeCode;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;

@Getter
@Setter
public class ImportDataRequest extends BaseEntityRequest {

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

    private Long partInfo;

    private Long initialED;

    private List<Long> bicDirectoryEntryList;
}
