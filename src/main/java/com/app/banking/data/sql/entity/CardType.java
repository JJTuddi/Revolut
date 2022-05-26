package com.app.banking.data.sql.entity;

import com.app.banking.data.sql.entity.enums.ECardType;
import com.app.banking.util.CsvWriteable;
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
public class CardType implements CsvWriteable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "name", nullable = false, length = 16)
    private ECardType name;

    @Lob
    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "maxWithdrawal", nullable = false)
    private Integer maxWithdrawal;

    @Column(name = "cashbackPercent", nullable = false)
    private Float cashbackPercent;


    @Override
    public String getCsvLine() {
        return id.toString() + ","  + name.toString() + "," + description + "," + maxWithdrawal.toString() + ","
                + cashbackPercent.toString() + "\n";
    }
}