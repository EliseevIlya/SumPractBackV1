package com.example.sumpractbackv1.model.entity;

import com.example.sumpractbackv1.model.enums.Rstr;
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

    @ManyToOne()
    @JoinColumn(name = "participant_info_id")
    private ParticipantInfo participantInfo;

}