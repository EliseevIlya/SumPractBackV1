package com.example.sumpractbackv1.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

import org.hibernate.annotations.SQLDelete;

@Entity
@Table(name = "initial_ed")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SQLDelete(sql = "UPDATE initial_ed SET deleted = true WHERE id = ?")
public class InitialED extends BaseEntity {

    @Column(name = "ed_no_initial", length = 9)
    private Long ednoInitial;

    @Column(name = "ed_date_initial")
    private LocalDate edDateInitial;

    @Column(name = "ed_author_initial", length = 10)
    private Long edAuthorInitial;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "import_data_initial_id")
    private ImportData importDataInitialId;

    @Column(name = "creation_time_initial")
    private LocalDate creationTimeInitial;

    @Column(name = "change_time_initial")
    private LocalDate changeTimeInitial;

    @Column(name = "delete_time_initial")
    private LocalDate deleteTimeInitial;
}
