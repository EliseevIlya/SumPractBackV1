package com.example.sumpractbackv1.model.parser;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class ParsSwbics {

    @XmlAttribute(name = "SWBIC")
    private String swbic;

    @XmlAttribute(name = "DefaultSWBIC")
    private Integer defaultSWBIC;
}
