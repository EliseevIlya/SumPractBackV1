package com.example.sumpractbackv1.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "initial_ed")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InitialED {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "initial_id")
    private Long initialId;

    @Column(name = "ed_no_initial",length = 9)
    private Long ednoInitial;

    @Column(name = "ed_date_initial")
    private LocalDate edDateInitial;

    @Column(name = "ed_author_initial",length = 10)
    private Long edAuthorInitial;
    //TODO время создания измения удаления
    //TODO связи к заголовочному файлу

    @ManyToOne()
    @JoinColumn(name = "import_data_initial_id", referencedColumnName = "import_id")
    private ImportData importDataInitialId;

    @Column(name = "creation_time_initial")
    @Temporal(TemporalType.DATE)
    private LocalDate creationTimeInitial;

    @Column(name = "change_time_initial")
    @Temporal(TemporalType.DATE)
    private LocalDate changeTimeInitial;

    @Column(name = "delete_time_initial")
    @Temporal(TemporalType.DATE)
    private LocalDate deleteTimeInitial;
}
