package com.example.entity.inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="CHEQUE")
public class ChequeSingleTable extends PaymentSingleTable {

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
