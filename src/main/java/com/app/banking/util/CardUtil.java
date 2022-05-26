package com.app.banking.util;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CardUtil {

    private final static Integer ibanLength = 34;

    @Value("${app.card.ibanPrefix}")
    private String ibanPrefix;

    private CardUtil() {

    }

    public String getIbanPrefix() {
        return ibanPrefix;
    }

    public Integer getIbanLength() {
        return ibanLength;
    }

    public String getRandomIban(String currency) {
        String result = ibanPrefix + currency + "CRT";
        while (result.length() < ibanLength) {
            result += (int) Math.floor(Math.random() * 10);
        }
        return result.toUpperCase();
    }

    public boolean isIbanFromCurrentBank(String iban) {
        return iban.startsWith(ibanPrefix);
    }

}
