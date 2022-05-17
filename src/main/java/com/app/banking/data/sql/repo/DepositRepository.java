package com.app.banking.data.sql.repo;

import com.app.banking.data.sql.entity.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepositRepository extends JpaRepository<Deposit, Long> {
}
