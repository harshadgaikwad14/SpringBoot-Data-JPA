package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Product1IdGenerateUsingAutoIncrement;

@Repository
public interface Product1CrudOperationRepository extends CrudRepository<Product1IdGenerateUsingAutoIncrement, Long>{

}
