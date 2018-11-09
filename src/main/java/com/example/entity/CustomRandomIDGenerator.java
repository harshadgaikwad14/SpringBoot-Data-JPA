package com.example.entity;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomRandomIDGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor arg0, Object arg1) throws HibernateException {

		final Date d =new Date();
		final String customId = "MyId_" +d.toString();
		System.out.println("My Custom Id : "+customId);
		return customId;
	}

}
