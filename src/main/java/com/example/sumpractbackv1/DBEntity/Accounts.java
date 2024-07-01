package com.example.sumpractbackv1.DBEntity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "Accounts")
@Getter
@Setter
public class Accounts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long accountId;

    @ManyToOne
    @JoinColumn(name = "bic_accounts_id", referencedColumnName = "BIC")
    private BICDirectoryEntry bicAccounts;

    @Column(name = "Account",  length = 22)
    private String account;

    @Column(name = "RegulationAccountType",  length = 5)
    private String regulationAccountType;

    @Column(name = "CK")
    private int ck;

    @Column(name = "AccountCBRBIC")
    private int accountCBRBIC;

    @Column(name = "DateIn_accounts")
    @Temporal(TemporalType.DATE)
    private Date dateInAccounts;

    @Column(name = "AccountStatus",  length = 5)
    private String accountStatus;



    // Getters and Setters
}
