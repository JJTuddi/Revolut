package com.app.banking.data.sql.repo;

import com.app.banking.data.sql.entity.CardType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardTypeRepository extends JpaRepository<CardType, Long> {
}
