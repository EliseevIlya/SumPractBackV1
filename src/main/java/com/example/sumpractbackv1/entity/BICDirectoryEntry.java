package com.example.sumpractbackv1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @OneToMany(mappedBy = "bicParticipant", cascade = CascadeType.ALL)
    private Set<ParticipantInfo> participantInfos;

    @JsonIgnore
    @OneToMany(mappedBy = "bicAccounts", cascade = CascadeType.ALL)
    private Set<Accounts> accounts;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "import_bic_id", referencedColumnName = "import_id")
    private ImportData importDataBic;

    // Getters and Setters
}

