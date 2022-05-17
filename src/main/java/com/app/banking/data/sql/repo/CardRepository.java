package com.app.banking.data.sql.repo;

import com.app.banking.data.sql.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
}
