package com.app.banking.data.dto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpensesOnMonthDto implements Serializable {
    private BusinessDto owner;
    private ExpensDto expense;
    private LocalDate onDate;
    private Double currentValue;
}
