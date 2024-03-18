package com.example.banking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.banking.entity.BankEntity;
import com.example.banking.service.BankServiceRepository;

@RestController
//@RequestMapping("")
public class BankController {
	
	@Autowired
	BankServiceRepository bankServ;
	
	@GetMapping("/all")
	public List<BankEntity> getAll() {
		
		return bankServ.getAll();
		
	}
	
	@PostMapping("/save")
	public String saveData(@RequestBody BankEntity bankData) {
		return bankServ.saveData(bankData);
		
	}
	
	@PutMapping("/update/{bankId}")
	public BankEntity updateData(@RequestBody BankEntity bank, @PathVariable("bankId")Integer bankId) {
		return bankServ.updateData(bank, bankId);
	}
	
	@DeleteMapping("/delete/{bankId}")
	public String deleteData(@PathVariable("bankId")Integer bankId) {
		return bankServ.deleteData(bankId);
	}

}
