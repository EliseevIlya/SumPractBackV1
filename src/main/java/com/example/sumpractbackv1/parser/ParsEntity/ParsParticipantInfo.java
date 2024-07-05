package com.example.sumpractbackv1.parser.ParsEntity;

import com.example.sumpractbackv1.enums.ParticipantStatus;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class ParsParticipantInfo {

    @XmlAttribute(name = "NameP")
    private String nameP;

    @XmlAttribute(name = "EnglName")
    private String engName;

    @XmlAttribute(name = "RegN")
    private String regN;

    @XmlAttribute(name = "CntrCd")
    private String cntrCd;

    @XmlAttribute(name = "Rgn")
    private String rgn;

    @XmlAttribute(name = "Ind")
    private String ind;

    @XmlAttribute(name = "Tnp")
    private String tnp;

    @XmlAttribute(name = "Nnp")
    private String nnp;

    @XmlAttribute(name = "Adr")
    private String adr;

    @XmlAttribute(name = "PrntBIC")
    private Long prntBIC;

    @XmlAttribute(name = "DateIn")
    private String dateIn;

    @XmlAttribute(name = "DateOut")
    private String dateOut;

    @XmlAttribute(name = "PtType")
    private String ptType;

    @XmlAttribute(name = "Srvcs")
    private String srvcs;

    @XmlAttribute(name = "XchType")
    private String xchType;

    @XmlAttribute(name = "UID")
    private Long uid;

    @XmlAttribute(name = "ParticipantStatus")
    private ParticipantStatus participantStatus;

    @XmlElement(name = "RstrList",namespace = "urn:cbr-ru:ed:v2.0")
    private List<ParsRstrList> parsRstrList;

    // Getters and Setters
}