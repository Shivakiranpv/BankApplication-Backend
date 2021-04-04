package com.harrisburg.controller;

import java.util.Optional;

import org.harrisburg.modal.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.harrisburg.dao.CustomerRepository;




@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Controller {
	

	@Autowired
	private CustomerRepository repository;


//@PostMapping("/hello")
public String getHellow( ){
	System.out.println("check");
	return  "{check row}";
}


@PostMapping("/hello")
public  void CustomerInfo(@RequestBody Customer customer){
	repository.save(customer);
	//System.out.println(customer.getFirstName()+" "+"saved in the DB");

}

@GetMapping("/{id}")
public Customer getById(@PathVariable(required = true) int id) {
	Optional<Customer> optionalCustomer = repository.findById(id);
    return optionalCustomer.orElseThrow(() -> new IllegalArgumentException("Customer doesn't exists with this: " + id));
}

}
