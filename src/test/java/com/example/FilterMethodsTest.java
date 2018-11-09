package com.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.entity.Product4;
import com.example.repository.Product4FilterMethodsRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FilterMethodsTest {

	@Autowired
	private Product4FilterMethodsRepository product4Repository;

	@Test
	public void contextLoads() {
	}

	/* 
	 * Search in google Spring Data Repository SQL Query Key Words
	 * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repository-query-keywords
	 * 
	 */

	@Test
	public void createProduct4() {
		for (int i = 0; i < 20; i++) {
			Product4 p = new Product4();

			if (i % 2 == 0) {
				p.setpName("YProduct_" + new Date());
				p.setpDesc("YProduct_" + new Date());
				p.setpFree(false);
				p.setpType("VEHICAL");
				p.setpAmount(new BigDecimal("500.23").add(new BigDecimal(i += 2)));
			} else {
				p.setpName("XProduct_" + new Date());
				p.setpDesc("XProduct_" + new Date());
				p.setpFree(true);
				p.setpType("SOFTWARE");
				p.setpAmount(new BigDecimal("100.99").add(new BigDecimal(i += 3)));
			}

			product4Repository.save(p);
		}

	}

	@Test
	public void findByPType() {
		List<Product4> p = product4Repository.findByPType("FOOD");
		for (Product4 product4 : p) {
			System.out.println(product4);
		}
	}

	@Test
	public void findByPTypeAndPFree() {
		List<Product4> p = product4Repository.findByPTypeAndPFree("SOFTWARE", true);
		for (Product4 product4 : p) {
			System.out.println("findByPTypeAndPFree : " + product4);
		}
	}

	@Test
	public void findByPAmountIsLessThan() {
		List<Product4> p = product4Repository.findByPAmountIsLessThan(new BigDecimal("400"));
		for (Product4 product4 : p) {
			System.out.println("findByPAmountIsLessThan : " + product4);
		}
	}

	@Test
	public void findByPDescContains() {
		List<Product4> p = product4Repository.findByPDescContains("FOOD");
		for (Product4 product4 : p) {
			System.out.println("findByPDescContains : " + product4);
		}
	}

	@Test
	public void findByPAmountBetween() {
		List<Product4> p = product4Repository.findByPAmountBetween(new BigDecimal("200"), new BigDecimal("500"));
		for (Product4 product4 : p) {
			System.out.println("findByPAmountBetween : " + product4);
		}
	}

	@Test
	public void findByPDescLike() {
		List<Product4> p = product4Repository.findByPDescLike("%mon%");
		for (Product4 product4 : p) {
			System.out.println("findByPDescLike : " + product4);
		}
	}

	@Test
	public void findByPIdIn() {
		List<Long> ids = new ArrayList<>();
		ids.add(20l);
		ids.add(22l);

		List<Product4> p = product4Repository.findByPIdIn(ids);
		for (Product4 product4 : p) {
			System.out.println("findByPIdIn : " + product4);
		}
	}

}
