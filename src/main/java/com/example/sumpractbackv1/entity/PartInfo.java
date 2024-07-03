package com.example.sumpractbackv1.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "PartInfo")
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

    @Column(name = "PartNo", length = 6)
    private Integer partNo;

    @Column(name = "PartQuantity",length = 6)
    private Integer partQuantity;

    @Column(name = "PartAggregateID", length = 27)
    private String partAggregateID;
    //TODO время создания измения удаления
    //TODO связи к заголовочному файлу
}
