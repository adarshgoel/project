package com.scb.creditcard.customer.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.scb.creditcard.customer.model.Customer;
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	
	@Query("SELECT email,mobileno, address, income FROM customerinfo WHERE customerinfo.pannumber = :pannumber")
	public List<Customer> findByPanNumber(@Param("pannumber") String panNumber);
}
