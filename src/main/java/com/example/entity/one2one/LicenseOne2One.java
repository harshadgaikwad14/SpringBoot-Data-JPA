package com.example.entity.one2one;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class LicenseOne2One {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long licenseId;
	private String number;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="pId")
	private PersonOne2One personOne2One;
	public long getLicenseId() {
		return licenseId;
	}
	public void setLicenseId(long licenseId) {
		this.licenseId = licenseId;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public PersonOne2One getPersonOne2One() {
		return personOne2One;
	}
	public void setPersonOne2One(PersonOne2One personOne2One) {
		this.personOne2One = personOne2One;
	}
	
	
	
	

}
