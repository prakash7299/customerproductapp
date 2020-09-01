package com.dxctraining.customermgt.customer.service;

import java.util.List;

import com.dxctraining.customermgt.customer.entities.Customer;


public interface ICustomerService {
	Customer findById(Integer id);
    Customer add(Customer customer);
    void removeById(Integer id);
    List<Customer> allCustomer();
    List<Customer> findByName(String name);
}
