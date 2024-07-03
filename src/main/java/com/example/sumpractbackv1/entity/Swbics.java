package com.example.sumpractbackv1.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "SWBICS")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Swbics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Swbic_id")
    private Long swbicsId;

    @Column(name = "DefaultSWBIC",length = 1)
    private Integer defaultSwbic;
    //TODO время создания измения удаления
    //TODO связи
}
