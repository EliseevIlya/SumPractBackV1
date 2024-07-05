package com.example.sumpractbackv1.entity;

import com.example.sumpractbackv1.enums.ChangeType;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

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
    private LocalDate creationTimeBicd;

    @Column(name = "change_time_bicd")
    @Temporal(TemporalType.DATE)
    private LocalDate changeTimeBicd;

    @Column(name = "delete_time_bicd")
    @Temporal(TemporalType.DATE)
    private LocalDate deleteTimeBicd;

    @OneToMany(mappedBy = "bicParticipantInfoId",cascade = CascadeType.MERGE)
    private List<ParticipantInfo> participantInfoList;

    @OneToMany(mappedBy = "bicSwibcsId",cascade = CascadeType.MERGE)
    private List<Swbics> swbicsList;

    @OneToMany(mappedBy = "bicAccountsId", cascade = CascadeType.MERGE)
    private List<Accounts> accountsList;

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