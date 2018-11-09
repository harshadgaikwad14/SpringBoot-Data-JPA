package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Product2IdGenerateUsingTable;

@Repository
public interface Product2CustomIdGeneratorWithTableRepository extends CrudRepository<Product2IdGenerateUsingTable, Long>{

}
