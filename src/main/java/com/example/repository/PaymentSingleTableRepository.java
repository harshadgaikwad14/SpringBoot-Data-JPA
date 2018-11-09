package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.inheritance.PaymentSingleTable;

@Repository
public interface PaymentSingleTableRepository extends CrudRepository<PaymentSingleTable, Long>{

}
