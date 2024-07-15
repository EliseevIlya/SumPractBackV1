package com.example.sumpractbackv1.model.entity;

import com.example.sumpractbackv1.model.enums.ChangeType;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.List;

@Entity
@Table(name = "bic_directory_entry")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SQLDelete(sql = "UPDATE bic_directory_entry SET deleted = true WHERE bic = ?")
public class BicDirectoryEntry extends BaseEntity {

    @Column(name = "bic", length = 9, nullable = false)
    private Long bic;

    @Column(name = "change_type", length = 4)
    private ChangeType changeType;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "import_data_id")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    private ImportData importData;

    @OneToOne(mappedBy = "bicDirectoryEntry", cascade = CascadeType.ALL)
    private ParticipantInfo participantInfo;

    @OneToMany(mappedBy = "bicDirectoryEntry", cascade = CascadeType.ALL)
    @JsonIdentityReference(alwaysAsId=true)
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    @SQLRestriction("deleted = false")
    private List<Swbics> swbicsList;

    @OneToMany(mappedBy = "bicDirectoryEntry", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIdentityReference(alwaysAsId=true)
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    @SQLRestriction("deleted = false")
    private List<Accounts> accountsList;

}