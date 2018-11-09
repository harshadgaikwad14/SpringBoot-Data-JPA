package com.example;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.entity.Product6;
import com.example.repository.Product6JpqlNativeSqlRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpqlAndNativeSqlTest {

	@Autowired
	private Product6JpqlNativeSqlRepository product6Repository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void createProduct6() {
		for (int i = 1; i <= 100; i++) {
			Product6 p = new Product6();

			if (i % 2 == 0) {
				p.setpName("Y " + i + " Product_" + new Date());
				p.setpDesc("Y " + i + " Product_" + new Date());
				p.setpFree(false);
				p.setpType("HARDWARE");
				p.setpAmount(new BigDecimal("" + i + 1));
			} else {
				p.setpName("X " + i + " Product_" + new Date());
				p.setpDesc("X " + i + " Product_" + new Date());
				p.setpFree(true);
				p.setpType("SOFTWARE");
				p.setpAmount(new BigDecimal("" + i * 2 / 3));
			}

			product6Repository.save(p);
		}

	}

	@Test
	public void findAllProduct6() {
		List<Product6> p = (List<Product6>) product6Repository.findAllProduct6();
		for (Product6 product6 : p) {
			System.out.println("findAllProduct6 : " + product6);
		}
	}

	@Test
	public void findAllProduct6SpecificColumn() {
		List<Object[]> p = (List<Object[]>) product6Repository.findAllProduct6SpecificColumn();
		for (Object[] objects : p) {
			System.out.println("findAllProduct6 : " + objects[0] + " -- " + objects[1]);
		}
	}

	@Test
	public void findAllProduct6ByFree() {
		List<Product6> p = (List<Product6>) product6Repository.findAllProduct6ByFree(true);
		for (Product6 product6 : p) {
			System.out.println("findAllProduct6ByFree : " + product6);
		}
	}

	@Test
	public void findAllProduct6ByRangeAmount() {
		List<Product6> p = (List<Product6>) product6Repository.findAllProduct6ByRangeAmount(new BigDecimal("10"),
				new BigDecimal("120"));
		for (Product6 product6 : p) {
			System.out.println("findAllProduct6ByRangeAmount : " + product6);
		}
	}

	@Test
	@Transactional
	@Rollback(false) // bydefault rollback is true in tranactional/Modifying data using Jnit
	public void deleteByFree() {
		product6Repository.deleteByFree(false);

	}

	@SuppressWarnings("deprecation")
	@Test
	public void findAllProduct6WithPaging() {
		List<Product6> p = (List<Product6>) product6Repository.findAllProduct6WithPaging(new PageRequest(0, 5));
		for (Product6 product6 : p) {
			System.out.println("findAllProduct6WithPaging : " + product6);
		}
	}

	@SuppressWarnings("deprecation")
	@Test
	public void findAllProduct6WithPagingSorting() {
		List<Product6> p = (List<Product6>) product6Repository
				.findAllProduct6WithPagingSorting(new PageRequest(0, 5, Direction.DESC, "pAmount", "pId"));

		for (Product6 product6 : p) {
			System.out.println("findAllProduct6WithPagingSorting : " + product6);
		}
	}
	
	
	@Test
	public void findAllProduct6NativeQuery() {
		List<Product6> p = (List<Product6>) product6Repository
				.findAllProduct6NativeQuery();

		for (Product6 product6 : p) {
			System.out.println("findAllProduct6NativeQuery : " + product6);
		}
	}
	
	@Test
	public void findAllProduct6ByFreeNativeQuery() {
		List<Product6> p = (List<Product6>) product6Repository.findAllProduct6ByFreeNativeQuery(true);
		for (Product6 product6 : p) {
			System.out.println("findAllProduct6ByFreeNativeQuery : " + product6);
		}
	}

	
	
	
	
	

}
