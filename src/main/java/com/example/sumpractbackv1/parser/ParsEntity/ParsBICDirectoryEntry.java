package com.example.sumpractbackv1.parser.ParsEntity;


import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class ParsBICDirectoryEntry {

    @XmlAttribute(name = "BIC")
    private int BIC;

    @XmlElement(name = "ParticipantInfo",namespace = "urn:cbr-ru:ed:v2.0")
    private List<ParsParticipantInfo> participantInfos;

    @XmlElement(name = "Accounts",namespace = "urn:cbr-ru:ed:v2.0")
    private List<ParsAccounts> accounts;

    // Getters and Setters
}