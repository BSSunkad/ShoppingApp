package com.shopping.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shopping.demo.entity.CustomerDetails;


@Repository
public interface CustomerRepository extends JpaRepository<CustomerDetails, String> {
	
	@Query(value = "select customer_id FROM loyalty WHERE customerId = :accountId", nativeQuery=true)
	String findCustomerById(@Param("accountId") String accountId);

//	CustomerDto save(CustomerDto customerDto);

//	Optional<CustomerDetails> findById(String id);

	

}
