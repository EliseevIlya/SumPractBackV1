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
@Table(name = "participant_info")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "participantId")
public class ParticipantInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "participant_id")
    private Long participantId;

    //TODO связи
   /* @ManyToOne
    @JoinColumn(name = "BIC_participant", referencedColumnName = "BIC")
    @JsonIdentityReference(alwaysAsId = true)
    private BICDirectoryEntry bicParticipant;*/

    @Column(name = "name_p", length = 160)
    private String nameP;

    @Column(name = "engl_name",length = 140)
    private String englName;

    @Column(name = "reg_n",length = 9)
    private String regN;

    @Column(name = "cntr_cd", length = 2)
    private String cntrCd;

    @Column(name = "rgn", length = 2)
    private String rgn;

    @Column(name = "ind", length = 6)
    private String ind;

    @Column(name = "tnp", length = 5)
    private String tnp;

    @Column(name = "nnp", length = 25)
    private String nnp;

    @Column(name = "adr", length = 160)
    private String adr;

    @Column(name = "prnt_bic",length = 9)
    private Long prntBIC;

    @Column(name = "date_in_participant")
    @Temporal(TemporalType.DATE)
    private Date dateInParticipant;

    @Column(name = "date_out_participant")
    @Temporal(TemporalType.DATE)
    private Date dateOutParticipant;

    @Column(name = "pt_type",length = 2)
    private String ptType;

    @Column(name = "srvcs",length = 1)
    private String srvcs;

    @Column(name = "xch_type",length = 1)
    private String xchType;

    @Column(name = "uid",length = 10)
    private long uid;

    @Column(name = "participant_status", length = 4)
    private ParticipantStatus participantStatus;

    //TODO время создания измения удаления
    //TODO связи

    @ManyToOne()
    @JoinColumn(name = "bic_participant_info_id", referencedColumnName = "bicd_id")
    private BICDirectoryEntry bicParticipantInfoId;

    @Column(name = "creation_time_participant_info")
    @Temporal(TemporalType.DATE)
    private Date creationTimeParticipantInfo;

    @Column(name = "change_time_participant_info")
    @Temporal(TemporalType.DATE)
    private Date changeTimeParticipantInfo;

    @Column(name = "delete_time_participant_info")
    @Temporal(TemporalType.DATE)
    private Date deleteTimeParticipantInfo;

    /*@OneToMany(mappedBy = "participantRstrId", cascade = CascadeType.ALL)
    @JsonIdentityReference(alwaysAsId = true)
    private Set<RstrList> rstrLists;*/

}