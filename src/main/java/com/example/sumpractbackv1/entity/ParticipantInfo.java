package com.example.sumpractbackv1.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "ParticipantInfo")
@Getter
@Setter
public class ParticipantInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "participant_id")
    private Long participantId;


    @ManyToOne
    @JoinColumn(name = "BIC_participant", referencedColumnName = "BIC")
    private BICDirectoryEntry bicParticipant;

    @Column(name = "NameP" , length = 255)
    private String nameP;

    @Column(name = "RegN")
    private String regN;

    @Column(name = "CntrCd",  length = 4)
    private String cntrCd;

    @Column(name = "Rgn")
    private int rgn;

    @Column(name = "Ind")
    private int ind;

    @Column(name = "Tnp" , length = 1)
    private String tnp;

    @Column(name = "Nnp",  length = 50)
    private String nnp;

    @Column(name = "Adr",  length = 255)
    private String adr;

    @Column(name = "DateIn_participant")
    @Temporal(TemporalType.DATE)
    private Date dateInParticipant;

    @Column(name = "PtType")
    private int ptType;

    @Column(name = "Srvcs")
    private int srvcs;

    @Column(name = "XchType")
    private int xchType;

    @Column(name = "UID")
    private long uid;

    @Column(name = "ParticipantStatus",  length = 5)
    private String participantStatus;

    @OneToMany(mappedBy = "participantRstrId", cascade = CascadeType.ALL)
    private Set<RstrList> rstrLists;

    // Getters and Setters
}
