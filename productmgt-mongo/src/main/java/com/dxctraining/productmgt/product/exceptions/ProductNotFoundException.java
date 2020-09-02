package com.dxctraining.productmgt.product.exceptions;

public class ProductNotFoundException extends RuntimeException{
	public ProductNotFoundException(String msg) {
		super(msg);
	}

}
