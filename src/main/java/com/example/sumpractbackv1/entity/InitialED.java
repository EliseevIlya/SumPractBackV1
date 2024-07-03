package com.example.sumpractbackv1.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "InitialED")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InitialED {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "initial_id")
    private Long initialId;

    @Column(name = "EDNo_initial",length = 9)
    private Long ednoInitial;

    @Column(name = "EDDate_initial")
    private LocalDate edDateInitial;

    @Column(name = "EDAuthor_initial",length = 10)
    private Long edAuthorInitial;
    //TODO время создания измения удаления
    //TODO связи к заголовочному файлу

}
