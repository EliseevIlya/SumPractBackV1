package com.example.sumpractbackv1.model.entity;

import com.example.sumpractbackv1.model.enums.Rstr;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "rstr_list")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "rstrId")
public class RstrList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rstr_id")
    private Long rstrId;

    //TODO связи
    /*@ManyToOne
    @JoinColumn(name = "participan_rstr_id", referencedColumnName = "participant_id")
    @JsonIdentityReference(alwaysAsId = true)
    private ParticipantInfo participantRstrId;*/

    @Column(name = "rstr", length = 4)
    private Rstr rstr;

    @Column(name = "rstr_date")
    private LocalDate rstrDate;

    //TODO время создания измения удаления
    //TODO связи

    @ManyToOne()
    @JoinColumn(name = "participant_info_rstr_list_id")
    private ParticipantInfo participantInfoRstrListId;

    @Column(name = "creation_time_rstr_list")
    private LocalDate creationTimeRstrList;

    @Column(name = "change_time_rstr_list")
    private LocalDate changeTimeRstrList;

    @Column(name = "delete_time_rstr_list")
    private LocalDate deleteTimeRstrList;
}