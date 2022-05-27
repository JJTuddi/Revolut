package com.app.banking.data.sql.entity;

import com.app.banking.util.CsvWriteable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "deposits")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Deposit implements CsvWriteable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "ownerId", nullable = false)
    private User owner;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "depositTypeId", nullable = false)
    private DepositType depositType;

    @Column(name = "createdOn", nullable = false)
    private LocalDateTime createdOn;

    @Column(name = "currentAmount", nullable = false)
    private Float currentAmount;

    @Column(name = "targetDate", nullable = false)
    private LocalDate targetDate;

    @Column(name = "targetAmount", nullable = false)
    private Float targetAmount;

    @Override
    public String getCsvLine() {
        return id.toString() + "," + owner.getId().toString() + "," + depositType.toString() + "," + createdOn.toString()
                + "," + currentAmount.toString() + "," + targetDate.toString() + "," + targetAmount.toString() + "\n";
    }
}