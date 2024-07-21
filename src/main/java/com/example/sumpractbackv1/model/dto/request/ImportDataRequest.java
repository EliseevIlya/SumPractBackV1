package com.example.sumpractbackv1.model.dto.request;

import com.example.sumpractbackv1.model.entity.ImportData;
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

    private String xmlns = "urn:cbr-ru:ed:v2.0";

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

    private List<Long> bicDirectoryEntryList = List.of();

    public ImportData toImportData() {
        var importData = ImportData.builder()
                .xmlns(xmlns)
                .edno(edno)
                .edDate(edDate)
                .edAuthor(edAuthor)
                .edReceiver(edReceiver)
                .creationReason(creationReason)
                .creationDateTime(creationDateTime)
                .infoTypeCode(infoTypeCode)
                .businessDay(businessDay)
                .directoryVersion(directoryVersion)
                .build();
        importData.setId(getId());
        return importData;
    }
}
