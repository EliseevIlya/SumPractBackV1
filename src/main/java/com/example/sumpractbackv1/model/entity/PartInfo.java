package com.example.sumpractbackv1.model.entity;

import org.hibernate.annotations.SQLDelete;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "part_info")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SQLDelete(sql = "UPDATE part_info SET deleted = true WHERE id = ?")
public class PartInfo extends BaseEntity {

    @Column(name = "part_no", length = 6)
    private Integer partNo;

    @Column(name = "part_quantity",length = 6)
    private Integer partQuantity;

    @Column(name = "part_aggregate_id", length = 27)
    private String partAggregateID;

    @ManyToOne()
    @JoinColumn(name = "importData_part_info_id")
    private ImportData importDataPartInfoId;

}
