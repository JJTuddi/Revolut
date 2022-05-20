package com.app.banking.data.sql.repo;

import com.app.banking.data.sql.entity.CardStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardStatusRepository extends JpaRepository<CardStatus, Integer> {
}
