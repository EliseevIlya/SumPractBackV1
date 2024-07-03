package com.example.sumpractbackv1.entity;

import com.example.sumpractbackv1.enums.ChangeType;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "BICDirectoryEntry", uniqueConstraints = @UniqueConstraint(columnNames = "BIC"))
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "BICDid")
public class BICDirectoryEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BICD_id")
    private Long bucId;

    @Column(name = "BIC",length = 9)
    private Long bic;

    @Column(name = "ChangeType",length = 4)
    private ChangeType changeType;

    //TODO время создания измения удаления
    //TODO связи

    @OneToMany(mappedBy = "bicParticipant", cascade = CascadeType.ALL)
    @JsonIdentityReference(alwaysAsId = true)
    private Set<ParticipantInfo> participantInfos;

    @OneToMany(mappedBy = "bicAccounts", cascade = CascadeType.ALL)
    @JsonIdentityReference(alwaysAsId = true)
    private Set<Accounts> accounts;

    @ManyToOne
    @JoinColumn(name = "import_bic_id", referencedColumnName = "import_id")
    @JsonIdentityReference(alwaysAsId = true)
    private ImportData importDataBic;
}