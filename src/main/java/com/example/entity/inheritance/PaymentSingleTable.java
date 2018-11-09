package com.example.entity.inheritance;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="paymentMode" ,discriminatorType=DiscriminatorType.STRING)
public abstract class PaymentSingleTable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long paymentId;
	private BigDecimal paymentAmt;
	public long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}
	public BigDecimal getPaymentAmt() {
		return paymentAmt;
	}
	public void setPaymentAmt(BigDecimal paymentAmt) {
		this.paymentAmt = paymentAmt;
	}
	@Override
	public String toString() {
		return "PaymentSingleTable [paymentId=" + paymentId + ", paymentAmt=" + paymentAmt + "]";
	}
	
	

}
