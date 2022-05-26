package com.app.banking.security.service;

import com.app.banking.data.mongo.track.UserHistoryTracker;
import com.app.banking.data.sql.entity.User;
import com.app.banking.data.sql.entity.enums.UserRole;
import com.app.banking.data.sql.entity.enums.UserStatus;
import com.app.banking.data.sql.repo.UserRepository;
import com.app.banking.security.dto.SignupRequest;
import com.app.banking.util.ServiceUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import static com.app.banking.data.sql.entity.enums.UserStatus.ACTIVE;

@Component
@RequiredArgsConstructor
public class AuthService {

    private static final UserStatus DEFAULT_STATUS = ACTIVE;
    private static final Double DEFAULT_ACCOUNT_BALANCE = 0.0;

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final ServiceUtil serviceUtil;
    private final UserHistoryTracker userHistoryTracker;

    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    // TODO add all details for this register
    public void register(SignupRequest signUpRequest) {
        User user = User.builder()
                .firstName(signUpRequest.getFirstName())
                .lastName(signUpRequest.getLastName())
                .username(signUpRequest.getUsername())
                .passwordHash(encoder.encode(signUpRequest.getPassword()))
                .email(signUpRequest.getEmail())
                .birthDate(serviceUtil.formatStringToDate(signUpRequest.getBirthDate()))
                .build();
        user.setRole(UserRole.CUSTOMER);
        userRepository.save(user);
        userHistoryTracker.auditCreate(user);
    }

}