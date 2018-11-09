package com.example.entity.one2many;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PhoneNumberOne2Many {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long phoneId;
	private String phoneNumber;
	@ManyToOne
	@JoinColumn(name="custId")
	private CustomerOne2Many customer;
	public long getPhoneId() {
		return phoneId;
	}
	public void setPhoneId(long phoneId) {
		this.phoneId = phoneId;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public CustomerOne2Many getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerOne2Many customer) {
		this.customer = customer;
	}
	
	

}
