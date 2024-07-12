package com.example.sumpractbackv1.model.parser;


import com.example.sumpractbackv1.model.entity.BICDirectoryEntry;
import com.example.sumpractbackv1.model.enums.ChangeType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class ParsBICDirectoryEntry {

    @XmlAttribute(name = "BIC")
    private Long bic;

    @XmlAttribute(name = "ChangeType")
    private ChangeType changeType;

    @XmlElement(name = "ParticipantInfo", namespace = "urn:cbr-ru:ed:v2.0")
    private ParsParticipantInfo parsParticipantInfo;

    @XmlElement(name = "SWBICS", namespace = "urn:cbr-ru:ed:v2.0")
    private List<ParsSwbics> parsSwbics;

    @XmlElement(name = "Accounts", namespace = "urn:cbr-ru:ed:v2.0")
    private List<ParsAccounts> parsAccounts;

    public BICDirectoryEntry toBICDirectoryEntry() {
        var bicDirectoryEntry = BICDirectoryEntry.builder()
                .bic(bic)
                .changeType(changeType)
                .participantInfo(parsParticipantInfo != null
                        ? parsParticipantInfo.toParticipantInfo()
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
        if (bicDirectoryEntry.getParticipantInfo() != null) {
            bicDirectoryEntry.getParticipantInfo().setBicDirectoryEntry(bicDirectoryEntry);
        }
        if (bicDirectoryEntry.getSwbicsList() != null) {
            bicDirectoryEntry.getSwbicsList().forEach(swbics ->
                swbics.setBicDirectoryEntry(bicDirectoryEntry));
        }
        if (bicDirectoryEntry.getAccountsList() != null) {
            bicDirectoryEntry.getAccountsList().forEach(accounts ->
                accounts.setBicDirectoryEntry(bicDirectoryEntry));
        }
        return bicDirectoryEntry;
    }

}