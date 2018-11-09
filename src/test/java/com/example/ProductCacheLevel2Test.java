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

import com.example.entity.cache.level2.ProductCacheLevel2;
import com.example.repository.ProductCacheLevel2Repository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCacheLevel2Test {

	@Autowired
	private ProductCacheLevel2Repository productCacheLevel2Repository;
	
	@Autowired
	private EntityManager entityManager;

	@Test
	public void contextLoads() {
	}

	@Test
	public void createProductCacheLevel2() {

		for (int i = 1; i <= 5; i++) {

			ProductCacheLevel2 p = new ProductCacheLevel2();
			p.setpName("Product " + i);
			p.setpDesc("Product Desc " + i);
			p.setpAmount(new BigDecimal(i));
			productCacheLevel2Repository.save(p);
		}

	}

	
	/*
	 * @Transactional is required to enable firstLevel Cache..
	 * Single select query will execute for below same operations
	 * 
	 */
	
	
	@Test
	@Transactional 
	public void readProductCacheLevel2() {

		productCacheLevel2Repository.findById(435l);
		productCacheLevel2Repository.findById(435l);
		productCacheLevel2Repository.findById(435l);
		productCacheLevel2Repository.findById(435l);
	}
	
	@Test
	@Transactional
	public void removedObjectFromSessionLevelCache()
	{
		System.out.println("******** Before Removing Object From Cache");
		Session session =entityManager.unwrap(Session.class);
		Optional<ProductCacheLevel2> p1=productCacheLevel2Repository.findById(435l);
		productCacheLevel2Repository.findById(435l);
		session.evict(p1.get()); // Removing Object from first level Cache
		System.out.println("******** After Removing Object From Cache");
		productCacheLevel2Repository.findById(435l); // Data Fetch From Second Level Cache
	}

}
