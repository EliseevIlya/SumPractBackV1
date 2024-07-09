package com.example.sumpractbackv1.parser.ParsEntity;


import com.example.sumpractbackv1.enums.ChangeType;
import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class ParsBICDirectoryEntry {

    @XmlAttribute(name = "BIC")
    private Long bic;

    @XmlAttribute(name = "ChangeType")
    private ChangeType changeType;

    @XmlElement(name = "ParticipantInfo",namespace = "urn:cbr-ru:ed:v2.0")
    private List<ParsParticipantInfo> parsParticipantInfos;

    @XmlElement(name = "SWBICS",namespace = "urn:cbr-ru:ed:v2.0")
    private List<ParsSwbics> parsSwbics;

    @XmlElement(name = "Accounts",namespace = "urn:cbr-ru:ed:v2.0")
    private List<ParsAccounts> parsAccounts;




    // Getters and Setters
}