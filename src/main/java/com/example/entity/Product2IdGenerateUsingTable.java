package com.example.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table
public class Product2IdGenerateUsingTable {
	
	
	/*
	 * Execute in mysql to create table id_gen
	 * 
	 * CREATE TABLE id_gen (
			id_name VARCHAR(50) NOT NULL,
			id_val BIGINT(20) NULL DEFAULT NULL,
			PRIMARY KEY (id_name)
		);*/

	
	@TableGenerator(name="productIdGenerator" , table="id_gen",pkColumnName="id_name",valueColumnName="id_val",allocationSize=2)
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE,generator="productIdGenerator")
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
