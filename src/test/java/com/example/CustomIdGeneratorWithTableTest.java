package com.example;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.entity.Product2IdGenerateUsingTable;
import com.example.repository.Product2CustomIdGeneratorWithTableRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomIdGeneratorWithTableTest {

	@Autowired
	private Product2CustomIdGeneratorWithTableRepository product2Repository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void createProduct2() {
		Product2IdGenerateUsingTable p = new Product2IdGenerateUsingTable();
		p.setpName("Product_" + new Date());
		p.setpDesc("Product_" + new Date());
		p.setpAmount(new BigDecimal("500.23"));

		product2Repository.save(p);
	}

}
