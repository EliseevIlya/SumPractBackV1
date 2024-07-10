package com.example.sumpractbackv1.model.entity;

import com.example.sumpractbackv1.model.enums.ParticipantStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.SQLDelete;

@Entity
@Table(name = "participant_info")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SQLDelete(sql = "UPDATE participant_info SET deleted = true WHERE id = ?")
public class ParticipantInfo extends BaseEntity {

    @Column(name = "name_p", length = 160)
    private String nameP;

    @Column(name = "engl_name", length = 140)
    private String englName;

    @Column(name = "reg_n", length = 9)
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

    @Column(name = "prnt_bic", length = 9)
    private Long prntBIC;

    @Column(name = "date_in_participant")
    private LocalDate dateInParticipant;

    @Column(name = "date_out_participant")
    private LocalDate dateOutParticipant;

    @Column(name = "pt_type",length = 2)
    private String ptType;

    @Column(name = "srvcs",length = 1)
    private String srvcs;

    @Column(name = "xch_type",length = 1)
    private String xchType;

    @Column(name = "uid",length = 10)
    private Long uid;

    @Column(name = "participant_status", length = 4)
    private ParticipantStatus participantStatus;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bic_participant_info_id")
    private BICDirectoryEntry bicParticipantInfoId;

    @OneToMany(mappedBy = "participantInfoRstrListId", cascade = CascadeType.ALL)
    private List<RstrList>  rstrLists;

}