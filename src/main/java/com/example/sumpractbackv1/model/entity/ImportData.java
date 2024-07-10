package com.example.sumpractbackv1.model.entity;

import com.example.sumpractbackv1.model.enums.CreationReason;
import com.example.sumpractbackv1.model.enums.InfoTypeCode;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;

import org.hibernate.annotations.SQLDelete;

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
@SQLDelete(sql = "UPDATE import_data SET deleted = true WHERE id = ?")
public class ImportData extends BaseEntity {

    @Column(name = "xmlns", length = 255)
    private String xmlns;

    @Column(name = "edno", length = 9)
    private Long edno;

    @Column(name = "ed_date")
    private LocalDate edDate;

    @Column(name = "ed_author", length = 10)
    private Long edAuthor;

    @Column(name = "ed_receiver", length = 10)
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

    @OneToMany(mappedBy = "importDataPartInfoId", cascade = CascadeType.ALL)
    private List<PartInfo> partInfoList;

    @OneToMany(mappedBy = "importDataInitialId", cascade = CascadeType.ALL)
    private List<InitialED> initialEDList;

    @OneToMany(mappedBy = "importDataBicId", cascade = CascadeType.ALL)
    private List<BICDirectoryEntry> bicDirectoryEntryList;

}