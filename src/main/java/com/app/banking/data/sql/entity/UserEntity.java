package com.app.banking.data.sql.entity;



import lombok.*;
import org.hibernate.Hibernate;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "noSqlId", nullable = false, length = 24)
    private String noSqlId;

    @Column(name = "firstName", nullable = false, length = 64)
    private String firstName;

    @Column(name = "lastName", nullable = false, length = 64)
    private String lastName;

    @Column(name = "username", nullable = false, length = 16)
    private String username;

    @Column(name = "passwordHash", nullable = false, length = 64)
    private String passwordHash;

    @Column(name = "email", nullable = false, length = 64)
    private String email;

    @Column(name = "role", nullable = false, length = 16)
    private String role;

    @Column(name = "birthDate", nullable = false)
    private LocalDate birthDate;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserEntity that = (UserEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}