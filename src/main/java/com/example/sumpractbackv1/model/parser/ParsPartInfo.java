package com.example.sumpractbackv1.model.parser;

import com.example.sumpractbackv1.model.entity.PartInfo;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class ParsPartInfo {

    @XmlAttribute(name = "PartNo")
    private Integer partNo;

    @XmlAttribute(name = "PartQuantity")
    private Integer partQuantity;

    @XmlAttribute(name = "PartAggregateID")
    private String partAggregateID;

    public PartInfo toPartInfo() {
        return PartInfo.builder()
                .partNo(partNo)
                .partQuantity(partQuantity)
                .partAggregateID(partAggregateID)
                .build();
    }

}
