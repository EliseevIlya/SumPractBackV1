package com.example.sumpractbackv1.model.dto.search;

import com.example.sumpractbackv1.model.enums.ParticipantStatus;
import lombok.*;

import java.time.LocalDate;

import org.springdoc.core.annotations.ParameterObject;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ParameterObject
public class ParticipantInfoSearchCriteria extends BaseEntitySearchCriteria {
    private String nameP;
    private String englName;
    private String regN;
    private String cntrCd;
    private String rgn;
    private String ind;
    private String tnp;
    private String nnp;
    private String adr;
    private Long prntBIC;
    private LocalDate dateInParticipant;
    private LocalDate dateOutParticipant;
    private String ptType;
    private String srvcs;
    private String xchType;
    private Long uid;
    private ParticipantStatus participantStatus;
    private Long bicParticipantInfoId;
}
