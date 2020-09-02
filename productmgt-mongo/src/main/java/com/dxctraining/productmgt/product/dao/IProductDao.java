package com.dxctraining.productmgt.product.dao;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dxctraining.productmgt.product.entities.Product;

public interface IProductDao extends MongoRepository<Product,String>{
	
	List<Product> findByPname(String pname);
 
}
