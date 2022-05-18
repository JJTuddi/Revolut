package com.app.banking.data.sql.repo;

import com.app.banking.data.sql.entity.UserEntity;
import org.apache.catalina.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;

import static com.app.banking.TestCreationFactory.randomDate;
import static com.app.banking.TestCreationFactory.randomString;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@ActiveProfiles("alexandra")
public class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

//    @BeforeEach
//    public void beforeEach() {
//        repository.deleteAll();
//    }

    @Test
    public void addUser() {


        String email = "email@employee.com";
        String password = "Abcdefg1234!";
        UserEntity userSaved = repository.save(UserEntity.builder()
                .firstName(randomString())
                .lastName(randomString())
                .username(randomString())
                .email(email)
                .passwordHash(randomString())
                .role(randomString())
                .birthDate(randomDate())
                .build());

        assertNotNull(userSaved);

        assertThrows(DataIntegrityViolationException.class, () -> {
            repository.save(UserEntity.builder()
                    .firstName(randomString())
                    .lastName(randomString())
                    .username(randomString())
                    .email(email)
                    .passwordHash(randomString())
                    .role(randomString())
                    .birthDate(randomDate())
                    .build());
        });
    }

    @Test
    public void existsByUsername(){
        String username = randomString();
        String email = "email@employee.com";
        String password = "Abcdefg1234!";
        UserEntity user = repository.save(UserEntity.builder()
                .firstName(randomString())
                .lastName(randomString())
                .username(randomString())
                .email(email)
                .passwordHash(randomString())
                .role(randomString())
                .birthDate(randomDate())
                .build());

        repository.save(user);
        Boolean result = repository.existsByUsername(username);
        assertEquals(result, true);
    }
}
