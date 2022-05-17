package com.app.banking.data.sql.repo;

import com.app.banking.data.sql.entity.UserEntity;
import org.apache.catalina.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import static com.app.banking.TestCreationFactory.randomDate;
import static com.app.banking.TestCreationFactory.randomString;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @BeforeEach
    public void beforeEach() {
        repository.deleteAll();
    }

    @Test
    public void addUser() {
//        String email = "email@employee.com";
//
//        UserEntity user = UserEntity.builder()
//                .firstName(randomString())
//                .lastName(randomString())
//                .username(randomString())
//                .email(email)
//                .passwordHash(randomString())
//                .role(randomString())
//                .birthDate(randomDate())
//                .build();
//
//        UserEntity savedUser = repository.save(user);
//
//        assertNotNull(savedUser);
//
//        assertEquals(user.getFirstName(), savedUser.getFirstName());
//        assertEquals(user.getLastName(), savedUser.getLastName());
//        assertEquals(user.getUsername(), savedUser.getUsername());
//        assertEquals(user.getPasswordHash(), savedUser.getPasswordHash());
//        assertEquals(user.getEmail(), savedUser.getEmail());
//        assertEquals(user.getRole(), savedUser.getRole());
//        assertEquals(user.getBirthDate(), savedUser.getBirthDate());
//
//        repository.deleteById(savedUser.getId());
//
//        assertThrows(DataIntegrityViolationException.class, () -> repository.getById(savedUser.getId()));
//
//
//        assertThrows(DataIntegrityViolationException.class, () -> {
//            repository.save(UserEntity.builder()
//                    .firstName(randomString())
//                    .lastName(randomString())
//                    .username(randomString())
//                    .email(email)
//                    .passwordHash(randomString())
//                    .role(randomString())
//                    .birthDate(randomDate())
//                    .build());
//        });
    }
}
