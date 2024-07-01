package com.example.sumpractbackv1.Parser.ParsEntity;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class ParsAccounts {

    @XmlAttribute(name = "Account")
    private String account;

    @XmlAttribute(name = "RegulationAccountType")
    private String regulationAccountType;

    @XmlAttribute(name = "CK")
    private int ck;

    @XmlAttribute(name = "AccountCBRBIC")
    private int accountCBRBIC;

    @XmlAttribute(name = "DateIn")
    @Temporal(TemporalType.DATE)
    private Date dateIn;

    @XmlAttribute(name = "AccountStatus")
    private String accountStatus;

    // Getters and Setters
}