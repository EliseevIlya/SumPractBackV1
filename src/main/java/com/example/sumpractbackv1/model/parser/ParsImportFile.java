package com.example.sumpractbackv1.model.parser;


import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.example.sumpractbackv1.model.entity.ImportData;
import com.example.sumpractbackv1.model.enums.CreationReason;
import com.example.sumpractbackv1.model.enums.InfoTypeCode;

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

    @XmlElement(name = "PartInfo",namespace = "urn:cbr-ru:ed:v2.0")
    private List<ParsPartInfo> parsPartInfo;

    @XmlElement(name = "InitialED",namespace = "urn:cbr-ru:ed:v2.0")
    private List<ParsInitialED> parsInitialED;

    @XmlElement(name = "BICDirectoryEntry",namespace = "urn:cbr-ru:ed:v2.0")
    private List<ParsBICDirectoryEntry> parsBICDirectoryEntries;

    public ImportData toImportData() {
        return ImportData.builder()
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
            .partInfoList(parsPartInfo != null
                ? parsPartInfo.stream()
                    .map(ParsPartInfo::toPartInfo)
                    .collect(Collectors.toList())
                : null)
            .initialEDList(parsInitialED != null
                ? parsInitialED.stream()
                    .map(ParsInitialED::toInitialED)
                    .collect(Collectors.toList())
                : null)
            .bicDirectoryEntryList(parsBICDirectoryEntries != null
                ? parsBICDirectoryEntries.stream()
                    .map(ParsBICDirectoryEntry::toBICDirectoryEntry)
                    .collect(Collectors.toList())
                : null)
            .build();
    }
    
}