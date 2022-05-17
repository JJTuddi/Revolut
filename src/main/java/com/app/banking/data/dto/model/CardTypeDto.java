package com.app.banking.data.dto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardTypeDto implements Serializable {
    private String name;
    private String description;
    private Integer maxWithdrawal;
    private Double cashbackPercent;
}
