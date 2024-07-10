package com.example.sumpractbackv1.model.parser;

import com.example.sumpractbackv1.model.entity.ParticipantInfo;
import com.example.sumpractbackv1.model.enums.ParticipantStatus;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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

    @XmlElement(name = "RstrList", namespace = "urn:cbr-ru:ed:v2.0")
    private List<ParsRstrList> parsRstrList;

    public ParticipantInfo toParticipantInfo() {
        return ParticipantInfo.builder()
                .nameP(nameP)
                .englName(engName)
                .regN(regN)
                .cntrCd(cntrCd)
                .rgn(rgn)
                .ind(ind)
                .tnp(tnp)
                .nnp(nnp)
                .adr(adr)
                .prntBIC(prntBIC)
                .dateInParticipant(dateIn != null ? LocalDate.parse(dateIn) : null)
                .dateOutParticipant(dateOut != null ? LocalDate.parse(dateOut) : null)
                .ptType(ptType)
                .srvcs(srvcs)
                .xchType(xchType)
                .uid(uid)
                .participantStatus(participantStatus)
                .rstrLists(parsRstrList != null
                        ? parsRstrList.stream()
                        .map(ParsRstrList::toRstrList)
                        .collect(Collectors.toList())
                        : null)
                .build();
    }
}