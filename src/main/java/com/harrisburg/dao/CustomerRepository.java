package com.harrisburg.dao;

import org.harrisburg.modal.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  CustomerRepository extends JpaRepository<Customer,Integer>{

}
