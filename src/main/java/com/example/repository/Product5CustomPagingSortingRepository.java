package com.example.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Product5;

@Repository
public interface Product5CustomPagingSortingRepository extends PagingAndSortingRepository<Product5, Long> {
	
	/*Custom Paging and Sorting*/
	List<Product5> findByPIdIn(final List<Long> ids, final Pageable pageable);
}
