package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.cache.level2.ProductCacheLevel2;

@Repository
public interface ProductCacheLevel2Repository extends CrudRepository<ProductCacheLevel2, Long>{

}
