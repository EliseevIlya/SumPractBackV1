package com.example.sumpractbackv1.entity;

import com.example.sumpractbackv1.enums.CreationReason;
import com.example.sumpractbackv1.enums.InfoTypeCode;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "ImportData")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "importId")
public class ImportData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "import_id")
    private Long importId;

    @Column(name = "xmlns", length = 255)
    private String xmlns;

    @Column(name = "EDNo",length = 9)
    private Long edno;

    @Column(name = "EDDate")
    private LocalDate edDate;

    @Column(name = "EDAuthor",length = 10)
    private Long edAuthor;

    @Column(name = "EDReceiver",length = 10)
    private Long edReceiver;

    @Column(name = "CreationReason", length = 4)
    private CreationReason creationReason;

    @Column(name = "CreationDateTime")
    private ZonedDateTime creationDateTime;

    @Column(name = "InfoTypeCode", length = 4)
    private InfoTypeCode infoTypeCode;

    @Column(name = "BusinessDay")
    private LocalDate businessDay;

    @Column(name = "DirectoryVersion")
    private Integer directoryVersion;

    //TODO время создания измения удаления
    @Column(name = "creation_time")
    @Temporal(TemporalType.DATE)
    private Date creationTime;

    @Column(name = "change_time")
    @Temporal(TemporalType.DATE)
    private Date changeTime;

    @Column(name = "delete_time")
    @Temporal(TemporalType.DATE)
    private Date deleteTime;

    //TODO связь
    @OneToMany(mappedBy = "importDataBic", cascade = CascadeType.MERGE)
    @JsonIdentityReference(alwaysAsId = true)
    private Set<BICDirectoryEntry> bicDirectoryEntries;
}