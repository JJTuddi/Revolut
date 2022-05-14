package com.app.banking.data.sql.entity;

import com.app.banking.data.sql.entity.enums.UserStatus;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String role;
    private String email;
    private String passwordHash;

}
