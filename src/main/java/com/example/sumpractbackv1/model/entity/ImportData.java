package com.example.sumpractbackv1.model.entity;

import com.example.sumpractbackv1.model.enums.CreationReason;
import com.example.sumpractbackv1.model.enums.InfoTypeCode;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;


@Entity
@Table(name = "import_data")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SQLDelete(sql = "UPDATE import_data SET deleted = true WHERE id = ?")
public class ImportData extends BaseEntity {

    @Column(name = "xmlns")
    private String xmlns;

    @Column(name = "edno", length = 9, nullable = false)
    private Long edno;

    @Column(name = "ed_date", nullable = false)
    private LocalDate edDate;

    @Column(name = "ed_author", length = 10, nullable = false)
    private Long edAuthor;

    @Column(name = "ed_receiver", length = 10)
    private Long edReceiver;

    @Column(name = "creation_reason", length = 4, nullable = false)
    private CreationReason creationReason;

    @Column(name = "creation_date_time", nullable = false)
    private ZonedDateTime creationDateTime;

    @Column(name = "info_type_code", length = 4, nullable = false)
    private InfoTypeCode infoTypeCode;

    @Column(name = "business_day", nullable = false)
    private LocalDate businessDay;

    @Column(name = "directory_version", length = 2)
    private Integer directoryVersion;

    @OneToOne(mappedBy = "importData", cascade = CascadeType.ALL)
    private PartInfo partInfo;

    @OneToOne(mappedBy = "importData", cascade = CascadeType.ALL)
    private InitialEd initialED;

    @OneToMany(mappedBy = "importData", cascade = CascadeType.ALL)
    @JsonIdentityReference(alwaysAsId = true)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @SQLRestriction("deleted = false")
    private List<BicDirectoryEntry> bicDirectoryEntryList;

}