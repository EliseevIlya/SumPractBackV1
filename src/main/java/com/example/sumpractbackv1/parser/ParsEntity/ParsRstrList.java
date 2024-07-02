package com.example.sumpractbackv1.parser.ParsEntity;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class ParsRstrList {

    @XmlAttribute(name = "Rstr")
    private String rstr;

    @XmlAttribute(name = "RstrDate")
    @Temporal(TemporalType.DATE)
    private Date rstrDate;

    // Getters and Setters
}