package com.app.banking.data.sql.repo;

import com.app.banking.data.sql.entity.DepositType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepositTypeRepository extends JpaRepository<DepositType, Long> {
}
