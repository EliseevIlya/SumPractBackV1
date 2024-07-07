package com.example.sumpractbackv1.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

import com.example.sumpractbackv1.model.enums.CreationReason;
import com.example.sumpractbackv1.model.enums.InfoTypeCode;


@Entity
@Table(name = "import_data")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "importId")
public class ImportData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "import_id")
    private Long importId;

    @Column(name = "xmlns", length = 255)
    private String xmlns;

    @Column(name = "edno",length = 9)
    private Long edno;

    @Column(name = "ed_date")
    private LocalDate edDate;

    @Column(name = "ed_author",length = 10)
    private Long edAuthor;

    @Column(name = "ed_receiver",length = 10)
    private Long edReceiver;

    @Column(name = "creation_reason", length = 4)
    private CreationReason creationReason;

    @Column(name = "creation_date_time")
    private ZonedDateTime creationDateTime;

    @Column(name = "info_type_code", length = 4)
    private InfoTypeCode infoTypeCode;

    @Column(name = "business_day")
    private LocalDate businessDay;

    @Column(name = "directory_version")
    private Integer directoryVersion;

    //TODO время создания измения удаления
    //TODO связь
    @Column(name = "creation_time_import")
    @Temporal(TemporalType.DATE)
    private LocalDate creationTimeImport;

    @Column(name = "change_time_import")
    @Temporal(TemporalType.DATE)
    private LocalDate changeTimeImport;

    @Column(name = "delete_time_import")
    @Temporal(TemporalType.DATE)
    private LocalDate deleteTimeImport;

    @OneToMany(mappedBy = "importDataPartInfoId",cascade = CascadeType.MERGE)
    private List<PartInfo> partInfoList;

    @OneToMany(mappedBy = "importDataInitialId", cascade = CascadeType.MERGE)
    private List<InitialED> initialEDList;

    @OneToMany(mappedBy = "importDataBicId", cascade = CascadeType.MERGE)
    private List<BICDirectoryEntry> bicDirectoryEntryList;

    //TODO связь
    /*@OneToMany(mappedBy = "importDataBic", cascade = CascadeType.MERGE)
    @JsonIdentityReference(alwaysAsId = true)
    private Set<BICDirectoryEntry> bicDirectoryEntries;*/
}