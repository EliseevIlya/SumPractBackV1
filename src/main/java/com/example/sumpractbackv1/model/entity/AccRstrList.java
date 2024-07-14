package com.example.sumpractbackv1.model.entity;

import com.example.sumpractbackv1.model.enums.AccRstr;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;

import java.time.LocalDate;


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

    @Column(name = "acc_rstr", length = 4, nullable = false)
    private AccRstr accRstr;

    @Column(name = "acc_rstr_date", nullable = false)
    private LocalDate accRstrDate;

    @Column(name = "successo_bic")
    private Long successorBIC;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "accounts_id")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    private Accounts accounts;

}
