package com.dxctraining.customermgt.customer.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import com.dxctraining.customermgt.customer.entities.Customer;

@DataJpaTest
@Import(CustomerServiceImpl.class)
public class CustomerServiceImplTest {

	@Autowired
	private ICustomerService service;

	@Test
	public void testSave_1() {
		String name = "prakash";
		Customer customer = new Customer(name);
		customer = service.add(customer);
		int id = customer.getId();
		Customer fetched = service.findById(id);
		Assertions.assertEquals(customer.getId(), fetched.getId());
		Assertions.assertEquals(customer.getName(), fetched.getName());

	}

	@Test
	public void testFindById_1() {
		String name = "praveen";
		Customer customer = new Customer(name);
		customer = service.add(customer);
		int id = customer.getId();
		Customer fetched = service.findById(id);
		Assertions.assertEquals(customer.getId(), fetched.getId());
		Assertions.assertEquals(customer.getName(), fetched.getName());

	}
	
	@Test
	public void findByName_1() {
		String name="karthik";
		Customer customer=new Customer(name);
		customer=service.add(customer);
		String cname=customer.getName();
		List<Customer> fetched=service.findByName(cname);
		Assertions.assertEquals(customer.getId(), fetched.get(0).getId());
		Assertions.assertEquals(customer.getName(),fetched.get(0).getName());
		
	}
	
	
}
