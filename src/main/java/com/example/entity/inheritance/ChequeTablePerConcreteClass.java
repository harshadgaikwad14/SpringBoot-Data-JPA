package com.example.entity.inheritance;

import javax.persistence.Entity;

@Entity
public class ChequeTablePerConcreteClass extends PaymentTablePerConcreteClass {

	private String chequeNumber;

	public String getChequeNumber() {
		return chequeNumber;
	}

	public void setChequeNumber(String chequeNumber) {
		this.chequeNumber = chequeNumber;
	}

	@Override
	public String toString() {
		return "ChequeSingleTable [chequeNumber=" + chequeNumber + "]";
	}

	
	

}
