package com.example.sumpractbackv1.model.dto.request;

import com.example.sumpractbackv1.model.enums.ParticipantStatus;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class ParticipantInfoRequest extends BaseEntityRequest {

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

    private LocalDate dateIn;

    private LocalDate dateOut;

    private String ptType;

    private String srvcs;

    private String xchType;

    private Long uid;

    private ParticipantStatus participantStatus;

    private Long bicDirectoryEntry;

    private List<Long> rstrLists;
}
