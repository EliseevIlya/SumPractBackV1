package com.example.sumpractbackv1.model.parser;

import com.example.sumpractbackv1.model.entity.AccRstrList;
import com.example.sumpractbackv1.model.enums.AccRstr;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class ParsAccRstrList {

    @XmlAttribute(name = "AccRstr")
    private AccRstr accRstr;

    @XmlAttribute(name = "AccRstrDate")
    private String accRstrDate;

    @XmlAttribute(name = "SuccessorBIC")
    private Long successorBIC;

    public AccRstrList toAccRstrList() {
        return AccRstrList.builder()
                .accRstr(accRstr)
                .accRstrDate(accRstrDate != null ? LocalDate.parse(accRstrDate) : null)
                .successorBIC(successorBIC)
                .build();
    }

}
