package com.example.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class Product3IdGenerateWithCustomClass {

	@GenericGenerator(name = "productCustomIdGenerator", strategy = "com.example.entity.CustomRandomIDGenerator")
	@Id
	@GeneratedValue(generator = "productCustomIdGenerator")
	private String pCustomId;
	private String pName;
	private String pDesc;
	private BigDecimal pAmount;

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpDesc() {
		return pDesc;
	}

	public void setpDesc(String pDesc) {
		this.pDesc = pDesc;
	}

	public BigDecimal getpAmount() {
		return pAmount;
	}

	public void setpAmount(BigDecimal pAmount) {
		this.pAmount = pAmount;
	}

	public String getpCustomId() {
		return pCustomId;
	}

	public void setpCustomId(String pCustomId) {
		this.pCustomId = pCustomId;
	}

	@Override
	public String toString() {
		return "Product3 [pCustomId=" + pCustomId + ", pName=" + pName + ", pDesc=" + pDesc + ", pAmount=" + pAmount
				+ "]";
	}

}
