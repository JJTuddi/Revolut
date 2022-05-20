package com.app.banking.data.sql.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "deposits")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Deposit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ownerId", nullable = false)
    private User owner;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "depositTypeId", nullable = false)
    private DepositType depositType;

    @Column(name = "createdOn", nullable = false)
    private LocalDate createdOn;

    @Column(name = "currentAmount", nullable = false)
    private Float currentAmount;

    @Column(name = "targetDate", nullable = false)
    private LocalDate targetDate;

    @Column(name = "targetAmount", nullable = false)
    private Float targetAmount;

}