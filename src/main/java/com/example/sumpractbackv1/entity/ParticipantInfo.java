package com.example.sumpractbackv1.entity;

import com.example.sumpractbackv1.enums.ParticipantStatus;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "ParticipantInfo")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "participantId")
public class ParticipantInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "participant_id")
    private Long participantId;

    //TODO связи
    @ManyToOne
    @JoinColumn(name = "BIC_participant", referencedColumnName = "BIC")
    @JsonIdentityReference(alwaysAsId = true)
    private BICDirectoryEntry bicParticipant;

    @Column(name = "NameP", length = 160)
    private String nameP;

    @Column(name = "EnglName",length = 140)
    private String englName;

    @Column(name = "RegN",length = 9)
    private String regN;

    @Column(name = "CntrCd", length = 2)
    private String cntrCd;

    @Column(name = "Rgn", length = 2)
    private String rgn;

    @Column(name = "Ind", length = 6)
    private String ind;

    @Column(name = "Tnp", length = 5)
    private String tnp;

    @Column(name = "Nnp", length = 25)
    private String nnp;

    @Column(name = "Adr", length = 160)
    private String adr;

    @Column(name = "PrntBIC",length = 9)
    private Long prntBIC;

    @Column(name = "DateIn_participant")
    @Temporal(TemporalType.DATE)
    private Date dateInParticipant;

    @Column(name = "DateOut_participant")
    @Temporal(TemporalType.DATE)
    private Date dateOutParticipant;

    @Column(name = "PtType",length = 2)
    private String ptType;

    @Column(name = "Srvcs",length = 1)
    private String srvcs;

    @Column(name = "XchType",length = 1)
    private String xchType;

    @Column(name = "UID",length = 10)
    private long uid;

    @Column(name = "ParticipantStatus", length = 4)
    private ParticipantStatus participantStatus;

    //TODO время создания измения удаления
    //TODO связи

    @OneToMany(mappedBy = "participantRstrId", cascade = CascadeType.ALL)
    @JsonIdentityReference(alwaysAsId = true)
    private Set<RstrList> rstrLists;

}