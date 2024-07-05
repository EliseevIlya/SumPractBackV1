package com.example.sumpractbackv1.parser.ParsEntity;

import com.example.sumpractbackv1.enums.AccRstr;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

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
