package com.example.sumpractbackv1.model.parser;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

import com.example.sumpractbackv1.model.enums.AccRstr;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class ParsAccRstrList {

    @XmlAttribute(name = "AccRstr")
    private AccRstr AccRstr;

    @XmlAttribute(name = "AccRstrDate")
    private String AccRstrDate;

    @XmlAttribute(name = "SuccessorBIC")
    private Long SuccessorBIC;

}
