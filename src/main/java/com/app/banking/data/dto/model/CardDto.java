package com.app.banking.data.dto.model;

import com.app.banking.data.dto.model.CardTypeDto;
import com.app.banking.data.dto.model.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CardDto implements Serializable {
    private UserDto owner;
    private CardTypeDto cardType;
    private Float currentAmount;
    private String cvv;
    private String number;
    private LocalDate expirationDate;
    private CardStatusDto cardStatus;

    @Override
    public boolean equals(Object o) {

        if (o == this) {
            return true;
        }

        if (!(o instanceof CardDto)) {
            return false;
        }

        CardDto c = (CardDto) o;

        return this.owner.equals(c.getOwner())
                && this.cardType.equals(c.getCardType())
                && this.currentAmount.equals(c.getCurrentAmount())
                && this.cvv.equals(c.getCvv())
                && this.number.equals(c.getNumber())
                && this.expirationDate.equals(c.getExpirationDate())
                && this.cardStatus.equals(c.getCardStatus());
    }
}
