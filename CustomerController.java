package com.scb.creditcard.customer.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scb.creditcard.customer.model.Customer;
import com.scb.creditcard.customer.exception.ResourceNotFoundException;
import com.scb.creditcard.customer.repository.CustomerRepository;

@RestController
@CrossOrigin
@RequestMapping("api/v1")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;
	
	
	//get all 
	@GetMapping("/customers")
	public List<Customer> getAllCustomers(){
		return customerRepository.findAll();
	}
	

	
	//create employee object
	@PostMapping("/customers")
	public Customer createCustomer(@RequestBody Customer customer) {
		return customerRepository.save(customer);
	}
	
	
	/*
	 * @PostMapping("/customers") public ResponseEntity<Map<String, Boolean>>
	 * findCustomer(@RequestParam String panNumber){ Customer customer = null; try {
	 * customer = customerRepository.findByPanNumber(panNumber) .orElseThrow(() ->
	 * new ResourceNotFoundException("Customer does not exist with pan number :" +
	 * panNumber)); } catch(ResourceNotFoundException e) { e.printStackTrace(); }
	 * 
	 * Map<String, Boolean> response = new HashMap<>(); response.put("added",
	 * Boolean.TRUE); return ResponseEntity.ok(response); }
	 */
	
	
	// delete customer rest api
    @DeleteMapping("/customers/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteCustomer(@PathVariable Long id){
        Customer customer = null;
        try {
            customer = customerRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Customer does not exist with id :" + id));
        } catch (ResourceNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        customerRepository.delete(customer);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
    
 // get customer by id rest api
    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        Customer customer = null;
        try {
            customer = customerRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Customer does not exist with id :" + id));
        } catch (ResourceNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ResponseEntity.ok(customer);
    }
}


