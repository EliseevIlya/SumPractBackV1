package com.example.sumpractbackv1.entity;

import com.example.sumpractbackv1.enums.AccountStatus;
import com.example.sumpractbackv1.enums.RegulationAccountType;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@Entity
@Table(name = "Accounts")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "accountId")
public class Accounts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long accountId;

    //TODO связи
    @ManyToOne
    @JoinColumn(name = "bic_accounts_id", referencedColumnName = "BIC")
    @JsonIdentityReference(alwaysAsId = true)
    private BICDirectoryEntry bicAccounts;

    @Column(name = "Account", length = 20)
    private String account;

    @Column(name = "RegulationAccountType", length = 4)
    private RegulationAccountType regulationAccountType;

    @Column(name = "CK",length = 2)
    private String ck;

    @Column(name = "AccountCBRBIC",length = 9)
    private Long accountCbrbic;

    @Column(name = "DateIn_accounts")
    @Temporal(TemporalType.DATE)
    private Date dateInAccounts;

    @Column(name = "DateOut_accounts")
    @Temporal(TemporalType.DATE)
    private Date dateOutAccounts;

    @Column(name = "AccountStatus", length = 4)
    private AccountStatus accountStatus;
    //TODO время создания измения удаления

}