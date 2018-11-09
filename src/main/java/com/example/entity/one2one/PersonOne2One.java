package com.example.entity.one2one;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class PersonOne2One {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long personId;
	private String name;
	@OneToOne(mappedBy="personOne2One")
	private LicenseOne2One licenseOne2One;
	public long getPersonId() {
		return personId;
	}
	public void setPersonId(long personId) {
		this.personId = personId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LicenseOne2One getLicenseOne2One() {
		return licenseOne2One;
	}
	public void setLicenseOne2One(LicenseOne2One licenseOne2One) {
		this.licenseOne2One = licenseOne2One;
	}

	
}
