package com.example.sumpractbackv1.model.entity;

import com.example.sumpractbackv1.model.enums.Rstr;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

import org.hibernate.annotations.SQLDelete;

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

    @Column(name = "rstr", length = 4)
    private Rstr rstr;

    @Column(name = "rstr_date")
    private LocalDate rstrDate;

    @ManyToOne()
    @JoinColumn(name = "participant_info_rstr_list_id")
    private ParticipantInfo participantInfoRstrListId;

}