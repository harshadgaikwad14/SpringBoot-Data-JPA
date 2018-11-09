package com.example.entity.one2many;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CustomerOne2Many {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long custId;
	private String custName;
	
	/*
	 * IMP Note
	 * 
	 * Bydefault fetchType is Lazy in oneToMany and ManyToMany association (fetch=FetchType.LAZY)
	 * If you are using FetchType.LAZY then readMethod of customer should be mark as @Transactional
	 * for example 
	 * @Transactional
	 * public void ReadCustomerOne2Many() {}
	 */
	@OneToMany(mappedBy="customer",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<PhoneNumberOne2Many> phoneNumbers;
	public long getCustId() {
		return custId;
	}
	public void setCustId(long custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public Set<PhoneNumberOne2Many> getPhoneNumbers() {
		return phoneNumbers;
	}
	public void setPhoneNumbers(Set<PhoneNumberOne2Many> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	
	public void addPhoneNumber(PhoneNumberOne2Many phone)
	{
		if(phone !=null)
		{
			if(phoneNumbers==null)
			{
				phoneNumbers = new HashSet<>();
			}
			phone.setCustomer(this);
			phoneNumbers.add(phone);
		}
	}
	
	

}
