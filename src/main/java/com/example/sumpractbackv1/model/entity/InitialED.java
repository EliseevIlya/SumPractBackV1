package com.example.sumpractbackv1.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;

import java.time.LocalDate;

@Entity
@Table(name = "initial_ed")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SQLDelete(sql = "UPDATE initial_ed SET deleted = true WHERE id = ?")
public class InitialED extends BaseEntity {

    @Column(name = "ed_no", length = 9, nullable = false)
    private Long edno;

    @Column(name = "ed_date", nullable = false)
    private LocalDate edDate;

    @Column(name = "ed_author", length = 10, nullable = false)
    private Long edAuthor;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "import_data_id")
    private ImportData importData;

}
