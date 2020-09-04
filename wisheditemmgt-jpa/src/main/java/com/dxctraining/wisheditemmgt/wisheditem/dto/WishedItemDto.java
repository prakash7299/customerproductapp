package com.dxctraining.wisheditemmgt.wisheditem.dto;

public class WishedItemDto {
	private String id;
	private String cname;
	private Integer customerId;
	private String productId;
	private String pname;
	
	
	public WishedItemDto() {
		
	}
	
	public WishedItemDto(String id,Integer customerId,String productId) {
		this.id=id;
		this.customerId=customerId;
		this.productId=productId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
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
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	
	
	
}
