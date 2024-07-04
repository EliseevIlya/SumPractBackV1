package com.example.sumpractbackv1.entity;

import com.example.sumpractbackv1.enums.ChangeType;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "BICDirectoryEntry")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "BICDid")
public class BICDirectoryEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bicd_id")
    private Long bicId;

    @Column(name = "bic",length = 9)
    private Long bic;

    @Column(name = "change_type",length = 4)
    private ChangeType changeType;

    //TODO время создания измения удаления
    //TODO связи

    @ManyToOne()
    @JoinColumn(name = "import_data_bic_id", referencedColumnName = "import_id")
    private ImportData importDataBicId;

    @Column(name = "creation_time_bicd")
    @Temporal(TemporalType.DATE)
    private Date creationTimeBicd;

    @Column(name = "change_time_bicd")
    @Temporal(TemporalType.DATE)
    private Date changeTimeBicd;

    @Column(name = "delete_time_bicd")
    @Temporal(TemporalType.DATE)
    private Date deleteTimeBicd;


   /* @OneToMany(mappedBy = "bicParticipant", cascade = CascadeType.ALL)
    @JsonIdentityReference(alwaysAsId = true)
    private Set<ParticipantInfo> participantInfos;

    @OneToMany(mappedBy = "bicAccounts", cascade = CascadeType.ALL)
    @JsonIdentityReference(alwaysAsId = true)
    private Set<Accounts> accounts;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "import_bic_id", referencedColumnName = "import_id")
    @JsonIdentityReference(alwaysAsId = true)
    private ImportData importDataBic;*/
}