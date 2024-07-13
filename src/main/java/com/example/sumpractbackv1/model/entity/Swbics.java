package com.example.sumpractbackv1.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;

@Entity
@Table(name = "swbics")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SQLDelete(sql = "UPDATE swbics SET deleted = true WHERE id = ?")
public class Swbics extends BaseEntity {

    @Column(name = "swbic", length = 11, nullable = false)
    private String swbic;

    @Column(name = "default_swbic", length = 1, nullable = false)
    private Integer defaultSwbic;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "bic_directory_entry_id")
    private BICDirectoryEntry bicDirectoryEntry;

}
