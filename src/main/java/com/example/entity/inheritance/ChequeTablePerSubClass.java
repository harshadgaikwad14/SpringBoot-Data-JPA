package com.example.entity.inheritance;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="paymentId")
public class ChequeTablePerSubClass extends PaymentTablePerSubClass {

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
