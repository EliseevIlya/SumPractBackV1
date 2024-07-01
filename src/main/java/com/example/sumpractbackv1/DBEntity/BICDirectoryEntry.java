package com.example.sumpractbackv1.DBEntity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.Set;

@Entity
@Table(name = "BICDirectoryEntry", uniqueConstraints = @UniqueConstraint(columnNames = "BIC"))
@Getter
@Setter
public class BICDirectoryEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BICD_id")
    private Long BICDid;

    @Column(name = "BIC")
    private int BIC;

    @OneToMany(mappedBy = "bicParticipant", cascade = CascadeType.ALL)
    private Set<ParticipantInfo> participantInfos;

    @OneToMany(mappedBy = "bicAccounts", cascade = CascadeType.ALL)
    private Set<Accounts> accounts;

    @ManyToOne
    @JoinColumn(name = "import_bic_id", referencedColumnName = "import_id")
    private ImportData importDataBic;

    // Getters and Setters
}

