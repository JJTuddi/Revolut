package com.app.banking.data.sql.repo;

import com.app.banking.data.sql.entity.Card;
import com.app.banking.data.sql.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {

    List<Card> findAllByOwnerId(Long id);
}
