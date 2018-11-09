package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.cache.level1.ProductCacheLevel1;

@Repository
public interface ProductCacheLevel1Repository extends CrudRepository<ProductCacheLevel1, Long>{

}
