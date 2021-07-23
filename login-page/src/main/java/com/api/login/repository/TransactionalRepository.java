package com.api.login.repository;

import com.api.login.entity.TransactionalAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionalRepository extends JpaRepository<TransactionalAccount,String> {
}
