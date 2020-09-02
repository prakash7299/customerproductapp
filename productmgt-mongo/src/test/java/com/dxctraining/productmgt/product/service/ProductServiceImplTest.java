package com.dxctraining.productmgt.product.service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.dxctraining.productmgt.product.entities.Product;



@DataMongoTest
@Import(ProductServiceImpl.class)
public class ProductServiceImplTest {

	@Autowired
	private IProductService service;
	
	
	@Test
	public void testSave_1() {
		String name="prakash";
		Product product=new Product(name);
		product=service.add(product);
		String id=product.getId();
		Product fetched=service.findById(id);
		Assertions.assertEquals(product.getId(),fetched.getId());
		Assertions.assertEquals(product.getPname(),fetched.getPname());
		
	}
	@Test
	public void testFindById_1() {
		String name="praveen";
		Product product=new Product(name);
		product=service.add(product);
		String id=product.getId();
		Product fetched=service.findById(id);
		Assertions.assertEquals(product.getId(),fetched.getId());
		Assertions.assertEquals(product.getPname(),fetched.getPname());
		
	}
	
	@Test
	public void findByName_1() {
		String name="karthik";
		Product customer=new Product(name);
		customer=service.add(customer);
		String cname=customer.getPname();
		List<Product> fetched=service.findByPname(cname);
		Assertions.assertEquals(customer.getId(), fetched.get(0).getId());
		Assertions.assertEquals(customer.getPname(),fetched.get(0).getPname());
		
	}
	
	
	
}
