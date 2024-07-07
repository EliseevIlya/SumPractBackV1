package com.example.sumpractbackv1.model.parser;


import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

import com.example.sumpractbackv1.model.entity.BICDirectoryEntry;
import com.example.sumpractbackv1.model.enums.ChangeType;

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

    public BICDirectoryEntry toBICDirectoryEntry() {
        return BICDirectoryEntry.builder()
            .bic(bic)
            .changeType(changeType)
            .participantInfoList(parsParticipantInfos != null
                ? parsParticipantInfos.stream()
                    .map(ParsParticipantInfo::toParticipantInfo)
                    .collect(Collectors.toList())
                : null)
            .swbicsList(parsSwbics != null
                ? parsSwbics.stream()
                    .map(ParsSwbics::toSwbics)
                    .collect(Collectors.toList())
                : null)
            .accountsList(parsAccounts != null
                ? parsAccounts.stream()
                    .map(ParsAccounts::toAccounts)
                    .collect(Collectors.toList())
                : null)
            .build();
    }

}