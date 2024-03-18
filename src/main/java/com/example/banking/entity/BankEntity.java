package com.example.banking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name= "bank")
@Data
public class BankEntity {
	@Id
	@Column(name = "ID")
	private Integer bankId;
	
	@Column(name = "BANKNAME")
	private String bankName;
	
	@Column(name = "BANKCODE")
	private Integer bankCode;
	
	@Column(name = "BANKADDRESS")
	private String bankAddress;
	
}
