package com.example.sumpractbackv1.entity;

import com.example.sumpractbackv1.enums.AccRstr;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Table(name = "InitialED")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccRstrList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AccRstrList_ig")
    private int accRstrListId;

    @Column(name = "AccRstr",length = 4)
    private AccRstr accRstr;

    @Column(name = "AccRstrDate")
    @Temporal(TemporalType.DATE)
    private Date accRstrDate;

    @Column(name = "SuccessorBIC")
    private Long successorBIC;
    //TODO связи
    //TODO время создания измения удаления
}
