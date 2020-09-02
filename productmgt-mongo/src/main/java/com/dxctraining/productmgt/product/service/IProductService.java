package com.dxctraining.productmgt.product.service;

import java.util.List;

import com.dxctraining.productmgt.product.entities.Product;


public interface IProductService {
	Product findById(String id);
	List<Product> findByPname(String name);

    Product add(Product product);

    void removeById(String id);
    List<Product> allProducts();

}
