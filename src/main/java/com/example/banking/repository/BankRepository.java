package com.example.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.banking.entity.BankEntity;

@Repository
public interface BankRepository extends JpaRepository<BankEntity, Integer> {

	
}
