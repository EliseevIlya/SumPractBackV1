package com.example.sumpractbackv1.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

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

    @Column(name = "swbic", length = 11)
    private String swbic;

    @Column(name = "default_swbic", length = 1)
    private Integer defaultSwbic;

    //TODO время создания измения удаления
    //TODO связи
    @ManyToOne()
    @JoinColumn(name = "bic_swibcs_id")
    private BICDirectoryEntry bicSwibcsId;

    @Column(name = "creation_time_swibcs")
    private LocalDate creationTimeSwibcs;

    @Column(name = "change_time_swibcs")
    private LocalDate changeTimeSwibcs;

    @Column(name = "delete_time_swibcs")
    private LocalDate deleteTimeSwibcs;
}
