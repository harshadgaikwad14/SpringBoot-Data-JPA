package com.example;

import java.math.BigDecimal;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.entity.cache.level1.ProductCacheLevel1;
import com.example.repository.ProductCacheLevel1Repository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCacheLevel1Test {

	@Autowired
	private ProductCacheLevel1Repository productCacheLevel1Repository;
	
	@Autowired
	private EntityManager entityManager;

	@Test
	public void contextLoads() {
	}

	@Test
	public void createProductCacheLevel1() {

		for (int i = 1; i <= 5; i++) {

			ProductCacheLevel1 p = new ProductCacheLevel1();
			p.setpName("Product " + i);
			p.setpDesc("Product Desc " + i);
			p.setpAmount(new BigDecimal(i));
			productCacheLevel1Repository.save(p);
		}

	}

	
	/*
	 * @Transactional is required to enable firstLevel Cache..
	 * Single select query will execute for below same operations
	 * 
	 */
	
	
	@Test
	@Transactional 
	public void readProductCacheLevel1() {

		productCacheLevel1Repository.findById(430l);
		productCacheLevel1Repository.findById(430l);
		productCacheLevel1Repository.findById(430l);
		productCacheLevel1Repository.findById(430l);
	}
	
	@Test
	@Transactional
	public void removedObjectFromSessionLevelCache()
	{
		Session session =entityManager.unwrap(Session.class);
		Optional<ProductCacheLevel1> p1=productCacheLevel1Repository.findById(430l);
		productCacheLevel1Repository.findById(430l);
		session.evict(p1.get()); // Removing Object from first level Cache
		productCacheLevel1Repository.findById(430l);
	}

}
