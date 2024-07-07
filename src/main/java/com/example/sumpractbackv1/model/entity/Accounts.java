package com.example.sumpractbackv1.model.entity;

import com.example.sumpractbackv1.model.enums.AccRstr;
import com.example.sumpractbackv1.model.enums.AccountStatus;
import com.example.sumpractbackv1.model.enums.RegulationAccountType;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "accounts")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "accountId")
public class Accounts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long accountId;

    //TODO связи
    /*@ManyToOne
    @JoinColumn(name = "bic_accounts_id", referencedColumnName = "BIC")
    @JsonIdentityReference(alwaysAsId = true)
    private BICDirectoryEntry bicAccounts;*/

    @Column(name = "account", length = 20)
    private String account;

    @Column(name = "regulation_account_type", length = 4)
    private RegulationAccountType regulationAccountType;

    @Column(name = "ck",length = 2)
    private String ck;

    @Column(name = "account_cbrbic",length = 9)
    private Long accountCbrbic;

    @Column(name = "date_in_accounts")
    @Temporal(TemporalType.DATE)
    private LocalDate dateInAccounts;

    @Column(name = "date_out_accounts")
    @Temporal(TemporalType.DATE)
    private LocalDate dateOutAccounts;

    @Column(name = "dccount_status", length = 4)
    private AccountStatus accountStatus;

    //TODO время создания измения удаления
    //TODO связи
    @ManyToOne()
    @JoinColumn(name = "bic_accounts_id", referencedColumnName = "BICD_id")
    private BICDirectoryEntry bicAccountsId;

    @OneToMany(mappedBy = "bicAccRstrListId", cascade = CascadeType.MERGE)
    private List<AccRstrList> accRstrLists;

    @Column(name = "creation_time_accounts")
    @Temporal(TemporalType.DATE)
    private LocalDate creationTimeAccounts;

    @Column(name = "change_time_accounts")
    @Temporal(TemporalType.DATE)
    private LocalDate changeTimeAccounts;

    @Column(name = "delete_time_accounts")
    @Temporal(TemporalType.DATE)
    private LocalDate deleteTimeAccounts;
}