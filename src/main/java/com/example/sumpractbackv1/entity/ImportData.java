package com.example.sumpractbackv1.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Set;

@Entity
@Table(name = "ImportData")
@Getter
@Setter
public class ImportData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "import_id")
    private Long importId;

    @Column(name = "xmlns",  length = 255)
    private String xmlns;

    @Column(name = "EDNo")
    private Long EDNo;

    @Column(name = "EDDate")
    private LocalDate EDDate;

    @Column(name = "EDAuthor")
    private String EDAuthor;

    @Column(name = "CreationReason")
    private String CreationReason;

    @Column(name = "CreationDateTime")
    private ZonedDateTime CreationDateTime;

    @Column(name = "InfoTypeCode")
    private String InfoTypeCode;

    @Column(name = "BusinessDay")
    private LocalDate BusinessDay;

    @Column(name = "DirectoryVersion")
    private Integer DirectoryVersion;

    @JsonIgnore
    @OneToMany(mappedBy = "importDataBic", cascade = CascadeType.ALL)
    private Set<BICDirectoryEntry> bicDirectoryEntries;

    // Getters and Setters
}
