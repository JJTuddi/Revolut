package com.app.banking.data.sql.entity;

import com.app.banking.util.CsvWriteable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cards")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Card implements CsvWriteable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "ownerId", nullable = false)
    private User owner;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "cardTypeId", nullable = false)
    private CardType cardType;

    @Column(name = "currentAmount", nullable = false)
    private Float currentAmount;

    @Column(name = "cvv", length = 3)
    private String cvv;

    @Column(name = "number", nullable = false, length = 16)
    private String number;

    @Column(name = "expirationDate", nullable = false)
    private LocalDateTime expirationDate;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "statusId", nullable = false)
    private CardStatus cardStatus;

    @Override
    public String getCsvLine() {
        return id.toString() + "," + owner.getId().toString() + "," + cardType.toString() + "," + currentAmount.toString()
                + "," + cvv + "," + number + "," + expirationDate.toString() + "," + cardStatus.toString() + "\n";
    }
}