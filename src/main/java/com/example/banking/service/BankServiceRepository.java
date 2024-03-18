package com.example.banking.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.banking.entity.BankEntity;

@Component
public interface BankServiceRepository {
	public List<BankEntity> getAll();
	public String saveData(BankEntity bankData);
	public BankEntity updateData(BankEntity bank, Integer bankId);
	public String deleteData(Integer bankId);

}

