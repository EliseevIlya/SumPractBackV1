package com.example.sumpractbackv1.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "swbics")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Swbics extends BaseEntity {

    @Column(name = "swbic",length = 11)
    private String swbic;

    @Column(name = "default_swbic",length = 1)
    private Integer defaultSwbic;

    @ManyToOne()
    @JoinColumn(name = "bic_swibcs_id")
    private BICDirectoryEntry bicSwibcsId;
    
}
