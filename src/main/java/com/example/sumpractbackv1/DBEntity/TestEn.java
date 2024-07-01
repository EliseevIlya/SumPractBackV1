package com.example.sumpractbackv1.DBEntity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Testdel")
@Getter
@Setter
public class TestEn {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "test")
    private String tes;
}
