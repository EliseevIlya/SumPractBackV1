package com.example.sumpractbackv1.Parser.ParsEntity;


import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@XmlRootElement(name = "ED807", namespace = "urn:cbr-ru:ed:v2.0")
@XmlAccessorType(XmlAccessType.FIELD)
public class ED807 {

    @XmlAttribute(name = "xmlns")
    private String xmlns;

    @XmlAttribute(name = "EDNo")
    private Long EDNo;

    @XmlAttribute(name = "EDDate")
    private String EDDate;

    @XmlAttribute(name = "EDAuthor")
    private String EDAuthor;

    @XmlAttribute(name = "CreationReason")
    private String CreationReason;

    @XmlAttribute(name = "CreationDateTime")
    private String CreationDateTime;

    @XmlAttribute(name = "InfoTypeCode")
    private String InfoTypeCode;

    @XmlAttribute(name = "BusinessDay")
    private String BusinessDay;

    @XmlAttribute(name = "DirectoryVersion")
    private Integer DirectoryVersion;

    @XmlElement(name = "BICDirectoryEntry",namespace = "urn:cbr-ru:ed:v2.0")
    private List<ParsBICDirectoryEntry> bicDirectoryEntries;

    // Getters and Setters
}