package com.example.sumpractbackv1.model.parser;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

import com.example.sumpractbackv1.model.enums.Rstr;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class ParsRstrList {

    @XmlAttribute(name = "Rstr")
    private Rstr rstr;

    @XmlAttribute(name = "RstrDate")
    @Temporal(TemporalType.DATE)
    private String rstrDate;

    // Getters and Setters
}