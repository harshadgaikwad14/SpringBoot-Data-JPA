package com.example.entity.component.mapping;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long eId;
	private String eName;
	
	@Embedded
	private Address eAddress;
	public long geteId() {
		return eId;
	}
	public void seteId(long eId) {
		this.eId = eId;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public Address geteAddress() {
		return eAddress;
	}
	public void seteAddress(Address eAddress) {
		this.eAddress = eAddress;
	}
	@Override
	public String toString() {
		return "Employee [eId=" + eId + ", eName=" + eName + ", eAddress=" + eAddress + "]";
	}
	
	
	
	

}
