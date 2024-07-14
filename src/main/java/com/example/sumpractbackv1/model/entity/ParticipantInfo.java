package com.example.sumpractbackv1.model.entity;

import com.example.sumpractbackv1.model.enums.ParticipantStatus;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "participant_info")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SQLDelete(sql = "UPDATE participant_info SET deleted = true, bic_directory_entry_id = null WHERE id = ?")
public class ParticipantInfo extends BaseEntity {

    @Column(name = "name_p", length = 160, nullable = false)
    private String nameP;

    @Column(name = "engl_name", length = 140)
    private String englName;

    @Column(name = "reg_n", length = 9)
    private String regN;

    @Column(name = "cntr_cd", length = 2)
    private String cntrCd;

    @Column(name = "rgn", length = 2, nullable = false)
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

    @Column(name = "date_in", nullable = false)
    private LocalDate dateIn;

    @Column(name = "date_out")
    private LocalDate dateOut;

    @Column(name = "pt_type", length = 2, nullable = false)
    private String ptType;

    @Column(name = "srvcs", length = 1, nullable = false)
    private String srvcs;

    @Column(name = "xch_type", length = 1, nullable = false)
    private String xchType;

    @Column(name = "uid", length = 10, nullable = false)
    private Long uid;

    @Column(name = "participant_status", length = 4)
    private ParticipantStatus participantStatus;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bic_directory_entry_id")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    private BICDirectoryEntry bicDirectoryEntry;

    @OneToMany(mappedBy = "participantInfo", cascade = CascadeType.ALL)
    @JsonIdentityReference(alwaysAsId=true)
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    @SQLRestriction("deleted = false")
    private List<RstrList> rstrLists;

}