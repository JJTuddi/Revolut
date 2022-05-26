package com.app.banking.data.dto.model;

import com.app.banking.data.sql.entity.enums.ECardType;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CardTypeDto implements Serializable {
    private ECardType name;
    private String description;
    private Integer maxWithdrawal;
    private Float cashbackPercent;

    @Override
    public boolean equals(Object o) {

        if (o == this) {
            return true;
        }

        if (!(o instanceof CardTypeDto)) {
            return false;
        }

        CardTypeDto c = (CardTypeDto) o;

        return this.name.equals(c.getName())
                && this.description.equals(c.getDescription())
                && this.maxWithdrawal.equals(c.getMaxWithdrawal())
                && this.cashbackPercent.equals(c.getCashbackPercent());
    }
}
