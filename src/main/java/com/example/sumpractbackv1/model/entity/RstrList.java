package com.example.sumpractbackv1.model.entity;

import com.example.sumpractbackv1.model.enums.Rstr;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;

import java.time.LocalDate;

@Entity
@Table(name = "rstr_list")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SQLDelete(sql = "UPDATE rstr_list SET deleted = true WHERE id = ?")
public class RstrList extends BaseEntity {

    @Column(name = "rstr", length = 4, nullable = false)
    private Rstr rstr;

    @Column(name = "rstr_date", nullable = false)
    private LocalDate rstrDate;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "participant_info_id")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    private ParticipantInfo participantInfo;

}