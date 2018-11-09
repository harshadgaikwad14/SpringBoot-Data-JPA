package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Product3IdGenerateWithCustomClass;

@Repository
public interface Product3CustomIdGeneratorRepository extends CrudRepository<Product3IdGenerateWithCustomClass, Long>{

}
