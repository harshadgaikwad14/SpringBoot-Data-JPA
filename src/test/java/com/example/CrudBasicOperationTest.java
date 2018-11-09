package com.example;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.entity.Product1IdGenerateUsingAutoIncrement;
import com.example.repository.Product1CrudOperationRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrudBasicOperationTest {

	@Autowired
	private Product1CrudOperationRepository product1Repository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void Product1() {
		Product1IdGenerateUsingAutoIncrement p = new Product1IdGenerateUsingAutoIncrement();
		p.setpName("Product_" + new Date());
		p.setpDesc("Product_" + new Date());
		p.setpAmount(new BigDecimal("500.23"));

		product1Repository.save(p);
	}

	@Test
	public void getProduct() {
		if (product1Repository.existsById(1l)) {
			Optional<Product1IdGenerateUsingAutoIncrement> p = product1Repository.findById(1l);
			System.out.println("Product :" + p.get());
		}
	}

	@Test
	public void getCount() {
		final long count = product1Repository.count();
		System.out.println("Total Number Of Records : " + count);
	}	

	@Test
	public void getAllProduct() {
		List<Product1IdGenerateUsingAutoIncrement> pList = (List<Product1IdGenerateUsingAutoIncrement>) product1Repository.findAll();

		for (Product1IdGenerateUsingAutoIncrement product : pList) {

			System.out.println("Product :" + product);

		}
	}

	@Test
	public void updateProduct() {
		if (product1Repository.existsById(1l)) {

			Optional<Product1IdGenerateUsingAutoIncrement> p = product1Repository.findById(1l);
			System.out.println("Product :" + p.get());
			p.get().setpAmount(new BigDecimal("900.23"));
			product1Repository.save(p.get());
		}
	}

	@Test
	public void existProduct() {
		final boolean isProductExist = product1Repository.existsById(10l);
		System.out.println("isProductExist : " + isProductExist);
	}

	@Test
	public void deleteProduct() {
		if (product1Repository.existsById(7l)) {

			product1Repository.deleteById(7l);
			/*
			 * Optional<Product> p = product1Repository.findById(6l);
			 * product1Repository.delete(p.get());
			 */

			// product1Repository.deleteAll();
		}

	}
}
