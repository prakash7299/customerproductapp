package com.dxctraining.productmgt.product.controller;

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

import com.dxctraining.productmgt.product.dto.CreateProductRequest;
import com.dxctraining.productmgt.product.dto.ProductDto;
import com.dxctraining.productmgt.product.dto.UpdateProductRequest;
import com.dxctraining.productmgt.product.entities.Product;
import com.dxctraining.productmgt.product.service.IProductService;

@RestController
@RequestMapping("/products")
public class ProductRestController {

	@Autowired
	private IProductService service;

	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public ProductDto create(@RequestBody CreateProductRequest data) {
		Product product = new Product(data.getPname());
		product = service.add(product);
		ProductDto response = toDto(product);
		return response;
	}
	
	@GetMapping("/find/{pname}")
	@ResponseStatus(HttpStatus.FOUND)
	public ProductDto findByPname(@PathVariable("pname") String pname) {
		List<Product> product = service.findByPname(pname);
		ProductDto dto = toDto(product.get(0));
		return dto;

	}

	@GetMapping("/get/{id}")
	@ResponseStatus(HttpStatus.FOUND)
	public ProductDto findProduct(@PathVariable("id") String id) {
		Product product = service.findById(id);
		ProductDto dto = toDto(product);
		return dto;
	}

	@PutMapping("/update")
	public ProductDto updateProduct(@RequestBody UpdateProductRequest data) {
		Product product = new Product(data.getPname());
		product.setId(data.getId());
		product = service.add(product);
		ProductDto dto = toDto(product);
		return dto;
	}

	@DeleteMapping("/delete/{id}")
	public void deleteProductById(@PathVariable("id") String id) {
		service.removeById(id);
	}
	public ProductDto toDto(Product product) {
		ProductDto dto = new ProductDto();
		dto.setId(product.getId());
		dto.setPname(product.getPname());
		return dto;
	}

}
