package com.app.banking.data.dto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {
    private String firstName;
    private String lastName;
    private String username;
    private String passwordHash;
    private String email;
    private String role;
    private LocalDate birthDate;

//    @Override
//    public boolean equals(Object o) {
//        if (o == this) {
//            return true;
//        }
//
//        if (!(o instanceof UserDto)) {
//            return false;
//        }
//
//        UserDto c = (UserDto) o;
//
//        return this.
//        return Double.compare(re, c.re) == 0
//                && Double.compare(im, c.im) == 0;
//    }
}
