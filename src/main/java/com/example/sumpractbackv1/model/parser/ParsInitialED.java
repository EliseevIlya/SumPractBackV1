package com.example.sumpractbackv1.model.parser;

import com.example.sumpractbackv1.model.entity.InitialED;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class ParsInitialED {

    @XmlAttribute(name = "EDNo")
    private Long edno;

    @XmlAttribute(name = "EDDate")
    private String edDate;

    @XmlAttribute(name = "EDAuthor")
    private Long edAuthor;

    public InitialED toInitialED() {
        return InitialED.builder()
                .edno(edno)
                .edDate(edDate != null ? LocalDate.parse(edDate) : null)
                .edAuthor(edAuthor)
                .build();
    }

}
