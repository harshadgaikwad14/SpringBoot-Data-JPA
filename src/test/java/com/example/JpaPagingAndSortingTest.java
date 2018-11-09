package com.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.entity.Product5;
import com.example.repository.Product5CustomPagingSortingRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaPagingAndSortingTest {

	@Autowired
	private Product5CustomPagingSortingRepository product5Repository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void createProduct5() {
		for (int i = 1; i <= 100; i++) {
			Product5 p = new Product5();

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

			product5Repository.save(p);
		}

	}

	@Test
	public void findAll() {
		List<Product5> p = (List<Product5>) product5Repository.findAll();
		for (Product5 product5 : p) {
			System.out.println("findAll : " + product5);
		}
	}

	@Test
	public void getPagingSortingAllRecords() {

		System.out.println(" -- paginate product sorted by amount  --");
		Pageable pageable = PageRequest.of(0, 3, Sort.by("pAmount").descending());

		while (true) {
			Page<Product5> page = product5Repository.findAll(pageable);
			System.out.println("Page no: " + page.getNumber());
			page.getContent().forEach(System.out::println);
			if (!page.hasNext()) {
				break;
			}
			pageable = page.nextPageable();
		}
	}

	@Test
	public void getPagingRecords() {

		System.out.println(" -- paginate product sorted by amount  --");
		Pageable pageable = PageRequest.of(0, 10);

		Page<Product5> page = product5Repository.findAll(pageable);
		page.getContent().forEach(System.out::println);

	}

	@Test
	public void getSortingRecords() {

		List<Product5> product = (List<Product5>) product5Repository.findAll(new Sort(Direction.DESC, "pAmount"));
		product.forEach(System.out::println);

	}

	@Test
	public void getSortingWithMulitpleFields() {

		List<Product5> product = (List<Product5>) product5Repository
				.findAll(new Sort(Direction.DESC, "pAmount", "pType"));
		product.forEach(System.out::println);

	}

	@SuppressWarnings("deprecation")
	@Test
	public void getSortingOrderWithMulitpleFields() {

		List<Product5> product = (List<Product5>) product5Repository
				.findAll(new Sort(new Sort.Order(Direction.ASC, "pAmount"),new Sort.Order(Direction.DESC, "pName")));
		product.forEach(System.out::println);

	}
	
	@Test
	public void findByPIdInPaging() {
		List<Long> ids = new ArrayList<>();
		ids.add(200l);
		ids.add(201l);
		ids.add(202l);
		ids.add(203l);
		ids.add(204l);
		Pageable pageable = PageRequest.of(1, 3);

		List<Product5> p = product5Repository.findByPIdIn(ids,pageable);
		for (Product5 product5 : p) {
			System.out.println("findByPIdIn : " + product5);
		}
	}

}
