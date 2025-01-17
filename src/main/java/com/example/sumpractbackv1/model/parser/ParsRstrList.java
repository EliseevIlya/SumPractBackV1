package com.example.sumpractbackv1.model.parser;

import com.example.sumpractbackv1.model.entity.RstrList;
import com.example.sumpractbackv1.model.enums.Rstr;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class ParsRstrList {

    @XmlAttribute(name = "Rstr")
    private Rstr rstr;

    @XmlAttribute(name = "RstrDate")
    private String rstrDate;

    public RstrList toRstrList() {
        return RstrList.builder()
                .rstr(rstr)
                .rstrDate(rstrDate != null ? LocalDate.parse(rstrDate) : null)
                .build();
    }

}