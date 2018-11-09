package com.example.entity.cache.level1;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class ProductCacheLevel1 {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long pId;
	private String pName;
	private String pDesc;
	private BigDecimal pAmount;
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
	@Override
	public String toString() {
		return "Product [pId=" + pId + ", pName=" + pName + ", pDesc=" + pDesc + ", pAmount=" + pAmount + "]";
	}
	
	
	

}
