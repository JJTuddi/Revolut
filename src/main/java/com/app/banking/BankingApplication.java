package com.app.banking;

import com.app.banking.data.sql.entity.UserEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class BankingApplication {

    public static void main(String[] args) {
        //SpringApplication.run(BankingApplication.class, args);
        UserEntity user = new UserEntity();
        user.setFirstName("aaa");
        user.getFirstName();
//        UserEntity user = UserEntity.builder()
//                .firstName("aaaa")
//                .lastName("aaaa")
//                .username("aaaa")
//                .email("aaaa@aa.com")
//                .passwordHash("aaaa")
//                .role("aaaa")
//                .birthDate(LocalDate.now())
//                .build();


    }

}
