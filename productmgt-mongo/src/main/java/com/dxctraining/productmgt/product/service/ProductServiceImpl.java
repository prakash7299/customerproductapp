package com.dxctraining.productmgt.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxctraining.productmgt.product.dao.IProductDao;
import com.dxctraining.productmgt.product.entities.Product;
import com.dxctraining.productmgt.product.exceptions.ProductNotFoundException;

@Service
public class ProductServiceImpl implements IProductService {
	@Autowired
	private IProductDao dao;

	@Override
	public Product findById(String id) {
		Optional<Product> optional = dao.findById(id);
		boolean exist = optional.isPresent();
		if (!exist) {
			throw new ProductNotFoundException("product not found for id=" + id);
		}
		Product products = optional.get();
		return products;
	}
	
	@Override
	public List<Product> findByPname(String pname) {
		List<Product> list=dao.findByPname(pname);
		return list;
		
	}

	@Override
	public Product add(Product product) {
		product = dao.save(product);
		return product;
	}

	@Override
	public void removeById(String id) {
		dao.deleteById(id);
	}

	@Override
	public List<Product> allProducts() {
		List<Product> allProducts = dao.findAll();
		return allProducts;
	}


}
