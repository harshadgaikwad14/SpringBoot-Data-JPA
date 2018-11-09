package com.example.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table

public class Product5 {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long pId;
	private String pName;
	private String pDesc;
	private BigDecimal pAmount;
	private boolean pFree;
	private String pType;
	

	public long getpId() {
		return pId;
	}

	public void setpId(long pId) {
		this.pId = pId;
	}

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
	
	

	public boolean ispFree() {
		return pFree;
	}

	public void setpFree(boolean pFree) {
		this.pFree = pFree;
	}

	public String getpType() {
		return pType;
	}

	public void setpType(String pType) {
		this.pType = pType;
	}

	@Override
	public String toString() {
		return "Product4 [pId=" + pId + ", pName=" + pName + ", pDesc=" + pDesc + ", pAmount=" + pAmount + ", pFree="
				+ pFree + ", pType=" + pType + "]";
	}

	
}
