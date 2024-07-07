package com.example.sumpractbackv1.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

import com.example.sumpractbackv1.model.enums.AccRstr;

@Entity
@Table(name = "acc_rstr_list")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccRstrList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "acc_rstr_list_id")
    private Long accRstrListId;

    @Column(name = "acc_rstr",length = 4)
    private AccRstr accRstr;

    @Column(name = "acc_rstr_date")
    @Temporal(TemporalType.DATE)
    private LocalDate accRstrDate;

    @Column(name = "successo_bic")
    private Long successorBIC;

    //TODO время создания измения удаления
    //TODO связи
    @ManyToOne()
    @JoinColumn(name = "accounts_acc_rstr_list_id", referencedColumnName = "account_id")
    private Accounts bicAccRstrListId;

    @Column(name = "creation_time_acc_rstr_list")
    @Temporal(TemporalType.DATE)
    private LocalDate creationTimeAccRstrList;

    @Column(name = "change_time_acc_rstr_list")
    @Temporal(TemporalType.DATE)
    private LocalDate changeTimeAccRstrList;

    @Column(name = "delete_time_acc_rstr_list")
    @Temporal(TemporalType.DATE)
    private LocalDate deleteTimeAccRstrList;
}
