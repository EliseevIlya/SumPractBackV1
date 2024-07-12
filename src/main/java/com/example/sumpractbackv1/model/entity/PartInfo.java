package com.example.sumpractbackv1.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;

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

    @Column(name = "part_no", length = 6, nullable = false)
    private Integer partNo;

    @Column(name = "part_quantity", length = 6, nullable = false)
    private Integer partQuantity;

    @Column(name = "part_aggregate_id", length = 27, nullable = false)
    private String partAggregateID;

    @OneToOne()
    @JoinColumn(name = "import_data_id")
    private ImportData importData;

}
