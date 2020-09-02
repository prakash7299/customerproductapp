package com.dxctraining.customermgt.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dxctraining.customermgt.customer.dto.CreateCustomerRequest;
import com.dxctraining.customermgt.customer.dto.CustomerDto;
import com.dxctraining.customermgt.customer.dto.UpdateCustomerRequest;
import com.dxctraining.customermgt.customer.entities.Customer;
import com.dxctraining.customermgt.customer.service.ICustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerRestController {

	@Autowired
	private ICustomerService service;

	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public CustomerDto create(@RequestBody CreateCustomerRequest data) {
		Customer customer = new Customer(data.getCname());
		customer = service.add(customer);
		CustomerDto response = toDto(customer);
		return response;
	}

	@GetMapping("/get/{id}")
	public CustomerDto findById(@PathVariable("id") Integer id) {
		Customer customer = service.findById(id);
		CustomerDto dto = toDto(customer);
		return dto;
	}

	@GetMapping("/find/{cname}")
	public CustomerDto findByName(@PathVariable("cname") String cname) {
		List<Customer> customer = service.findByCname(cname);
		CustomerDto dto = toDto(customer.get(0));
		return dto;

	}

	@PutMapping("/update")
	public CustomerDto updateCustomer(@RequestBody UpdateCustomerRequest data) {
		Customer customer = new Customer(data.getCname());
		customer.setId(data.getId());
		customer = service.add(customer);
		CustomerDto dto = toDto(customer);
		return dto;
	}

	@DeleteMapping("/delete/{id}")
	public void deleteCustomerById(@PathVariable("id") Integer id) {
		service.removeById(id);
	}

	public CustomerDto toDto(Customer customer) {
		CustomerDto dto = new CustomerDto();
		dto.setId(customer.getId());
		dto.setCname(customer.getCname());
		return dto;
	}

}
