package com.example.banking.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.banking.entity.BankEntity;
import com.example.banking.repository.BankRepository;

@Service
public class BankServiceImpl implements BankServiceRepository {
	
	@Autowired
	BankRepository bankRepo;

	@Override
	public List<BankEntity> getAll() {
        List<BankEntity> allData= bankRepo.findAll();
		return allData;
	}

	@Override
    public String saveData(BankEntity bankData) {
        return Optional.ofNullable(bankRepo.findById(bankData.getBankId()))
                .filter(Optional::isEmpty)
                .map(empty -> {
                    bankRepo.save(bankData);
                    return "Data Saved Successfully";
                })
                .orElse("Data is already existing");
    }

	@Override
	public BankEntity updateData(BankEntity bank, Integer bankId) {
		// simply for Updating the data ,if Id is available then Update by saving data
		 
		BankEntity update = bankRepo.findById(bankId).get();// logic for finding the bankId
		if(Objects.nonNull(bank.getBankName()) && ! " ".equalsIgnoreCase(bank.getBankName())) {
			update.setBankName(bank.getBankName());
		}
//		if(Objects.nonNull(bank.getBankCode()) && ! " ".equalsIgnoreCase(bank.getBankCode())) {
//			update.setBankCode(bank.getBankCode());
//		}
		if(Objects.nonNull(bank.getBankAddress()) && ! " ".equalsIgnoreCase(bank.getBankAddress())) {
			update.setBankAddress(bank.getBankAddress());
		}
		return bankRepo.save(update);
	}

	@Override
    public String deleteData(Integer bankId) {
        return Optional.of(bankId)
                .filter(bankRepo::existsById)
                .map(id -> {
                    bankRepo.deleteById(id);
                    return "Data Deleted";
                })
                .orElse("Invalid Data");
    }
	
}

