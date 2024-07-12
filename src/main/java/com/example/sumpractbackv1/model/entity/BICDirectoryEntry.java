package com.example.sumpractbackv1.model.entity;

import com.example.sumpractbackv1.model.enums.ChangeType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;

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
public class BICDirectoryEntry extends BaseEntity {

    @Column(name = "bic", length = 9)
    private Long bic;

    @Column(name = "change_type", length = 4)
    private ChangeType changeType;

    @ManyToOne()
    @JoinColumn(name = "import_data_bic_id")
    private ImportData importDataBicId;

    @OneToMany(mappedBy = "bicParticipantInfoId", cascade = CascadeType.ALL)
    private List<ParticipantInfo> participantInfoList;

    @OneToMany(mappedBy = "bicSwibcsId", cascade = CascadeType.ALL)
    private List<Swbics> swbicsList;

    @OneToMany(mappedBy = "bicAccountsId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Accounts> accountsList;

}