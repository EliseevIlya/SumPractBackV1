package com.example.sumpractbackv1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "RstrList")
@Getter
@Setter
public class RstrList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rstr_id")
    private Long rstrId;

    @ManyToOne
    @JoinColumn(name = "participan_rstr_id", referencedColumnName = "participant_id")
    private ParticipantInfo participantRstrId;

    @Column(name = "Rstr",  length = 5)
    private String rstr;

    @Column(name = "RstrDate")
    @Temporal(TemporalType.DATE)
    private Date rstrDate;

    // Getters and Setters
}
