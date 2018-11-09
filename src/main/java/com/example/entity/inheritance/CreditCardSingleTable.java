package com.example.entity.inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="CREDIT_CARD")
public class CreditCardSingleTable extends PaymentSingleTable {

	private String creditCardNumber;

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	@Override
	public String toString() {
		return "CreditCardSingleTable [creditCardNumber=" + creditCardNumber + "]";
	}
	
	

}
