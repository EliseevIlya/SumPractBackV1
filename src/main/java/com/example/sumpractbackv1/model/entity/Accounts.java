package com.example.sumpractbackv1.model.entity;

import com.example.sumpractbackv1.model.enums.AccountStatus;
import com.example.sumpractbackv1.model.enums.RegulationAccountType;
import jakarta.persistence.*;
import lombok.*;

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
public class Accounts extends BaseEntity {

    @Column(name = "account", length = 20)
    private String account;

    @Column(name = "regulation_account_type", length = 4)
    private RegulationAccountType regulationAccountType;

    @Column(name = "ck",length = 2)
    private String ck;

    @Column(name = "account_cbrbic",length = 9)
    private Long accountCbrbic;

    @Column(name = "date_in_accounts")
    private LocalDate dateInAccounts;

    @Column(name = "date_out_accounts")
    private LocalDate dateOutAccounts;

    @Column(name = "account_status", length = 4)
    private AccountStatus accountStatus;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bic_accounts_id")
    private BICDirectoryEntry bicAccountsId;

    @OneToMany(mappedBy = "accountsId", cascade = CascadeType.ALL)
    private List<AccRstrList> accRstrLists;

}