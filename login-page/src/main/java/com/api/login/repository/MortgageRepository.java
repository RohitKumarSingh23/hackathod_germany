package com.api.login.repository;

import com.api.login.entity.Mortgage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MortgageRepository extends JpaRepository<Mortgage,String> {
}
