package com.example.sumpractbackv1.model.entity;

import com.example.sumpractbackv1.model.enums.AccountStatus;
import com.example.sumpractbackv1.model.enums.RegulationAccountType;
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
@Table(name = "accounts")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SQLDelete(sql = "UPDATE accounts SET deleted = true WHERE id = ?")
public class Accounts extends BaseEntity {

    @Column(name = "account", length = 20, nullable = false)
    private String account;

    @Column(name = "regulation_account_type", length = 4, nullable = false)
    private RegulationAccountType regulationAccountType;

    @Column(name = "ck", length = 2)
    private String ck;

    @Column(name = "account_cbrbic", length = 9, nullable = false)
    private Long accountCbrbic;

    @Column(name = "date_in", nullable = false)
    private LocalDate dateIn;

    @Column(name = "date_out")
    private LocalDate dateOut;

    @Column(name = "account_status", length = 4)
    private AccountStatus accountStatus;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "bic_directory_entry_id")@JsonIdentityReference(alwaysAsId=true)
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    private BICDirectoryEntry bicDirectoryEntry;

    @OneToMany(mappedBy = "accounts", cascade = CascadeType.ALL)
    @JsonIdentityReference(alwaysAsId=true)
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    @SQLRestriction("deleted = false")
    private List<AccRstrList> accRstrLists;

}