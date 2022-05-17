package com.app.banking.data.dto.model;

import com.app.banking.data.dto.model.CardTypeDto;
import com.app.banking.data.dto.model.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardDto implements Serializable {
    private UserDto owner;
    private CardTypeDto cardType;
    private Double currentAmount;
    private String cvv;
    private String number;
    private LocalDate expirationDate;
}
