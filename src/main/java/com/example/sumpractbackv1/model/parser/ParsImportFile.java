package com.example.sumpractbackv1.model.parser;


import com.example.sumpractbackv1.model.entity.ImportData;
import com.example.sumpractbackv1.model.enums.CreationReason;
import com.example.sumpractbackv1.model.enums.InfoTypeCode;
import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@XmlRootElement(name = "ED807", namespace = "urn:cbr-ru:ed:v2.0")
@XmlAccessorType(XmlAccessType.FIELD)
public class ParsImportFile {

    @XmlAttribute(name = "xmlns")
    private String xmlns;

    @XmlAttribute(name = "EDNo")
    private Long edno;

    @XmlAttribute(name = "EDDate")
    private String edDate;

    @XmlAttribute(name = "EDAuthor")
    private Long edAuthor;

    @XmlAttribute(name = "EDReceiver")
    private Long edReceiver;

    @XmlAttribute(name = "CreationReason")
    private CreationReason creationReason;

    @XmlAttribute(name = "CreationDateTime")
    private String creationDateTime;

    @XmlAttribute(name = "InfoTypeCode")
    private InfoTypeCode infoTypeCode;

    @XmlAttribute(name = "BusinessDay")
    private String businessDay;

    @XmlAttribute(name = "DirectoryVersion")
    private Integer directoryVersion;

    @XmlElement(name = "PartInfo", namespace = "urn:cbr-ru:ed:v2.0")
    private ParsPartInfo parsPartInfo;

    @XmlElement(name = "InitialED", namespace = "urn:cbr-ru:ed:v2.0")
    private ParsInitialED parsInitialED;

    @XmlElement(name = "BICDirectoryEntry", namespace = "urn:cbr-ru:ed:v2.0")
    private List<ParsBICDirectoryEntry> parsBICDirectoryEntries;

    public ImportData toImportData() {
        var importData = ImportData.builder()
                .xmlns("urn:cbr-ru:ed:v2.0")
                .edno(edno)
                .edDate(edDate != null ? LocalDate.parse(edDate) : null)
                .edAuthor(edAuthor)
                .edReceiver(edReceiver)
                .creationReason(creationReason)
                .creationDateTime(creationDateTime != null ?
                        ZonedDateTime.parse(creationDateTime) : null)
                .infoTypeCode(infoTypeCode)
                .businessDay(businessDay != null ?
                        LocalDate.parse(businessDay) : null)
                .directoryVersion(directoryVersion)
                .partInfo(parsPartInfo != null
                        ? parsPartInfo.toPartInfo()
                        : null)
                .initialED(parsInitialED != null
                        ? parsInitialED.toInitialED()
                        : null)
                .bicDirectoryEntryList(parsBICDirectoryEntries != null
                        ? parsBICDirectoryEntries.stream()
                        .map(ParsBICDirectoryEntry::toBICDirectoryEntry)
                        .collect(Collectors.toList())
                        : null)
                .build();
        if (importData.getPartInfo() != null) {
            importData.getPartInfo().setImportData(importData);
        }
        if (importData.getInitialED() != null) {
            importData.getInitialED().setImportData(importData);
        }
        if (importData.getBicDirectoryEntryList() != null) {
            importData.getBicDirectoryEntryList().forEach(bicDirectoryEntry ->
                    bicDirectoryEntry.setImportData(importData));
        }
        return importData;
    }

}