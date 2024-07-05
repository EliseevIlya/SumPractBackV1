package com.example.sumpractbackv1.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "swbics")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Swbics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "swbic_id")
    private Long swbicsId;

    @Column(name = "swbic",length = 11)
    private String swbic;

    @Column(name = "default_swbic",length = 1)
    private Integer defaultSwbic;

    //TODO время создания измения удаления
    //TODO связи
    @ManyToOne()
    @JoinColumn(name = "bic_swibcs_id", referencedColumnName = "bicd_id")
    private BICDirectoryEntry bicSwibcsId;

    @Column(name = "creation_time_swibcs")
    @Temporal(TemporalType.DATE)
    private LocalDate creationTimeSwibcs;

    @Column(name = "change_time_swibcs")
    @Temporal(TemporalType.DATE)
    private LocalDate changeTimeSwibcs;

    @Column(name = "delete_time_swibcs")
    @Temporal(TemporalType.DATE)
    private LocalDate deleteTimeSwibcs;
}
