package com.app.banking.data.sql.entity;

import com.app.banking.data.sql.entity.enums.ECardStatus;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "card_status")
public class CardStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "name", nullable = false, length = 16)
    private ECardStatus name;

    @Lob
    @Column(name = "description")
    private String description;
}