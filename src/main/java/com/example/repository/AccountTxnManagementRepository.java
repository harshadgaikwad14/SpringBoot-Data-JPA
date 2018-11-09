package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.transaction.management.AccountTxnManagement;

@Repository
public interface AccountTxnManagementRepository extends CrudRepository<AccountTxnManagement, Long>{

}
