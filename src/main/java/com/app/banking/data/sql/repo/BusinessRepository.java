package com.app.banking.data.sql.repo;

import com.app.banking.data.sql.entity.Business;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessRepository extends JpaRepository<Business, Long> {
}
