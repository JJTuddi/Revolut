package com.app.banking.data.sql.entity;



import com.app.banking.util.CsvWriteable;
import lombok.*;
import org.hibernate.Hibernate;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User implements CsvWriteable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

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
    private LocalDateTime birthDate;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User that = (User) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String getCsvLine() {
        return id.toString() + "," + noSqlId + "," + firstName + "," + lastName + "," + username + "," +
                passwordHash + "," + email + "," + role + "," + birthDate.toString() + "\n";
    }
}