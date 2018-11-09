package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.inheritance.PaymentTablePerSubClass;

@Repository
public interface PaymentTablePerSubClassRepository extends CrudRepository<PaymentTablePerSubClass, Long>{

}
