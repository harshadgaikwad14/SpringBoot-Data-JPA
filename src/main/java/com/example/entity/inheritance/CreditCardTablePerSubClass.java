package com.example.entity.inheritance;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "paymentId")
public class CreditCardTablePerSubClass extends PaymentTablePerSubClass {

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
