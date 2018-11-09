package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.inheritance.PaymentTablePerConcreteClass;

@Repository
public interface PaymentTablePerConcreteClassRepository extends CrudRepository<PaymentTablePerConcreteClass, Long>{

}
