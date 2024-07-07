package com.example.sumpractbackv1.model.parser;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

import com.example.sumpractbackv1.model.enums.AccountStatus;
import com.example.sumpractbackv1.model.enums.RegulationAccountType;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class ParsAccounts {

    @XmlAttribute(name = "Account")
    private String account;

    @XmlAttribute(name = "RegulationAccountType")
    private RegulationAccountType regulationAccountType;

    @XmlAttribute(name = "CK")
    private String ck;

    @XmlAttribute(name = "AccountCBRBIC")
    private Long accountCBRBIC;

    @XmlAttribute(name = "DateIn")
    private String dateIn;

    @XmlAttribute(name = "DateOut")
    private String dateOut;

    @XmlAttribute(name = "AccountStatus")
    private AccountStatus accountStatus;

    @XmlElement(name = "AccRstrList",namespace = "urn:cbr-ru:ed:v2.0")
    private List<ParsAccRstrList> parsAccRstrList;
    // Getters and Setters
}