package com.example.sumpractbackv1.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "part_info")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PartInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "part_info_id")
    private Long partInfoId;

    @Column(name = "part_no", length = 6)
    private Integer partNo;

    @Column(name = "part_quantity", length = 6)
    private Integer partQuantity;

    @Column(name = "part_aggregate_id", length = 27)
    private String partAggregateID;

    //TODO время создания измения удаления
    //TODO связи к заголовочному файлу

    @ManyToOne()
    @JoinColumn(name = "importData_part_info_id")
    private ImportData importDataPartInfoId;

    @Column(name = "creation_time_part_info")
    private LocalDate creationTimePartInfo;

    @Column(name = "change_time_part_info")
    private LocalDate changeTimePartInfo;

    @Column(name = "delete_time_part_info")
    private LocalDate deleteTimePartInfo;

}
