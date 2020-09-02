package com.dxctraining.wisheditemmgt.wisheditem.dto;

public class CreateWishedItemRequest {
	private String id;
	private Integer customerId;
	private String productId;
	
	

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	

	

}
