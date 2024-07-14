package com.example.sumpractbackv1.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "part_info")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SQLDelete(sql = "UPDATE part_info SET deleted = true, import_data_id = null WHERE id = ?")
public class PartInfo extends BaseEntity {

    @Column(name = "part_no", length = 6, nullable = false)
    private Integer partNo;

    @Column(name = "part_quantity", length = 6, nullable = false)
    private Integer partQuantity;

    @Column(name = "part_aggregate_id", length = 27, nullable = false)
    private String partAggregateID;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "import_data_id")
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId=true)
    private ImportData importData;

}
