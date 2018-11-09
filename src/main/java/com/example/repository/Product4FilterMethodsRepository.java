package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Product4;
import java.lang.String;
import java.math.BigDecimal;
import java.util.List;

@Repository
public interface Product4FilterMethodsRepository extends CrudRepository<Product4, Long>{
	List<Product4> findByPType(final String ptype);
	List<Product4> findByPTypeAndPFree(final String ptype,final boolean pFree);
	List<Product4> findByPAmountIsLessThan(final BigDecimal amt);
	List<Product4> findByPDescContains(final String pDesc);
	List<Product4> findByPAmountBetween(final BigDecimal amtFrom,final BigDecimal amtTo);
	List<Product4> findByPDescLike(final String pDesc);
	List<Product4> findByPIdIn(final List<Long> ids);

}
