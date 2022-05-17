package com.app.banking.data.sql.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "card_types")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CardType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 16)
    private String name;

    @Lob
    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "maxWithdrawal", nullable = false)
    private Integer maxWithdrawal;

    @Column(name = "cashbackPercent", nullable = false)
    private Double cashbackPercent;
}