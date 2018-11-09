package com.example;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.entity.Product3IdGenerateWithCustomClass;
import com.example.repository.Product3CustomIdGeneratorRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomIdGeneratorWithClassTest {

	@Autowired
	private Product3CustomIdGeneratorRepository product3Repository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void createProduct3() {
		Product3IdGenerateWithCustomClass p = new Product3IdGenerateWithCustomClass();
		p.setpName("Product_" + new Date());
		p.setpDesc("Product_" + new Date());
		p.setpAmount(new BigDecimal("500.23"));

		product3Repository.save(p);
	}

}
