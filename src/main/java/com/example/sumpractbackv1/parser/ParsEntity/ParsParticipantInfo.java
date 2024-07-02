package com.example.sumpractbackv1.parser.ParsEntity;

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

    @XmlAttribute(name = "RegN")
    private String regN;

    @XmlAttribute(name = "CntrCd")
    private String cntrCd;

    @XmlAttribute(name = "Rgn")
    private int rgn;

    @XmlAttribute(name = "Ind")
    private int ind;

    @XmlAttribute(name = "Tnp")
    private String tnp;

    @XmlAttribute(name = "Nnp")
    private String nnp;

    @XmlAttribute(name = "Adr")
    private String adr;

    @XmlAttribute(name = "DateIn")
    @Temporal(TemporalType.DATE)
    private Date dateIn;

    @XmlAttribute(name = "PtType")
    private int ptType;

    @XmlAttribute(name = "Srvcs")
    private int srvcs;

    @XmlAttribute(name = "XchType")
    private int xchType;

    @XmlAttribute(name = "UID")
    private long uid;

    @XmlAttribute(name = "ParticipantStatus")
    private String participantStatus;

    @XmlElement(name = "RstrList",namespace = "urn:cbr-ru:ed:v2.0")
    private List<ParsRstrList> rstrLists;

    // Getters and Setters
}