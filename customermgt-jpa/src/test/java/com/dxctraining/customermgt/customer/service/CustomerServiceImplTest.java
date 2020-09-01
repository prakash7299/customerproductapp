package com.dxctraining.customermgt.customer.service;

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
	private ICustomerService supplierService;

	@Test
	public void testSave_1() {
		String name = "prakash";
		Customer supplier1 = new Customer(name);
		supplier1 = supplierService.add(supplier1);
		int id = supplier1.getId();
		Customer fetched = supplierService.findById(id);
		Assertions.assertEquals(supplier1.getId(), fetched.getId());
		Assertions.assertEquals(supplier1.getName(), fetched.getName());

	}

	@Test
	public void testFindById_1() {
		String name = "praveen";
		Customer supplier1 = new Customer(name);
		supplier1 = supplierService.add(supplier1);
		int id = supplier1.getId();
		Customer fetched = supplierService.findById(id);
		Assertions.assertEquals(supplier1.getId(), fetched.getId());
		Assertions.assertEquals(supplier1.getName(), fetched.getName());

	}

}
