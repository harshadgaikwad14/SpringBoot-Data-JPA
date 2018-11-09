package com.example.entity.inheritance;

import javax.persistence.Entity;

@Entity
public class CreditCardTablePerConcreteClass extends PaymentTablePerConcreteClass {

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
