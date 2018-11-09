package com.example.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.Product6;

@Repository
public interface Product6JpqlNativeSqlRepository extends CrudRepository<Product6, Long> {
	
	@Query("from Product6")
	List<Product6> findAllProduct6();
	
	@Query("select pId,pName from Product6")
	List<Object[]> findAllProduct6SpecificColumn();
	
	
	@Query("from Product6 where pFree=:free")
	List<Product6> findAllProduct6ByFree(@Param("free") boolean productFree);
	
	@Query("from Product6 where pAmount >:minAmt and pAmount <=:maxAmt")
	List<Product6> findAllProduct6ByRangeAmount(@Param("minAmt") BigDecimal productMinAmt,@Param("maxAmt") BigDecimal productMaxAmt);
	
	@Modifying
	@Query("delete from Product6 where pFree=:free")
	void deleteByFree(@Param("free") boolean productFree);
	
	@Query("from Product6")
	List<Product6> findAllProduct6WithPaging(final Pageable pageable);
	
	@Query("from Product6")
	List<Product6> findAllProduct6WithPagingSorting(final Pageable pageable);
	
	
	@Query(value="select * from product6",nativeQuery=true)
	List<Product6> findAllProduct6NativeQuery();
	
	@Query(value="select * from product6 where p_free=:free",nativeQuery=true)
	List<Product6> findAllProduct6ByFreeNativeQuery(@Param("free") boolean productFree);
	
	
}
