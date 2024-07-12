package com.example.sumpractbackv1.model.entity;

import com.example.sumpractbackv1.model.enums.AccountStatus;
import com.example.sumpractbackv1.model.enums.RegulationAccountType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;

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
    @JoinColumn(name = "bic_directory_entry_id")
    private BICDirectoryEntry bicDirectoryEntry;

    @OneToMany(mappedBy = "accounts", cascade = CascadeType.ALL)
    private List<AccRstrList> accRstrLists;

}