package com.example.sumpractbackv1.model.entity;

import com.example.sumpractbackv1.model.enums.AccRstr;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

import org.hibernate.annotations.SQLDelete;

import com.example.sumpractbackv1.model.enums.AccRstr;

@Entity
@Table(name = "acc_rstr_list")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SQLDelete(sql = "UPDATE acc_rstr_list SET deleted = true WHERE id=?")
public class AccRstrList extends BaseEntity {

    @Column(name = "acc_rstr", length = 4)
    private AccRstr accRstr;

    @Column(name = "acc_rstr_date")
    private LocalDate accRstrDate;

    @Column(name = "successo_bic")
    private Long successorBIC;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "accounts_id")
    private Accounts accountsId;

}
