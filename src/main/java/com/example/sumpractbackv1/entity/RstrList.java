package com.example.sumpractbackv1.entity;

import com.example.sumpractbackv1.enums.Rstr;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "RstrList")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "rstrId")
public class RstrList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rstr_id")
    private Long rstrId;


    //TODO связи
    @ManyToOne
    @JoinColumn(name = "participan_rstr_id", referencedColumnName = "participant_id")
    @JsonIdentityReference(alwaysAsId = true)
    private ParticipantInfo participantRstrId;

    @Column(name = "Rstr", length = 4)
    private Rstr rstr;

    @Column(name = "RstrDate")
    @Temporal(TemporalType.DATE)
    private Date rstrDate;

    //TODO время создания измения удаления
}