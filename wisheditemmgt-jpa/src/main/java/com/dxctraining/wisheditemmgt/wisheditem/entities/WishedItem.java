package com.dxctraining.wisheditemmgt.wisheditem.entities;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "wisheditems")
public class WishedItem {

	@Id
	private String id;
	
	private Integer customerId;
	
	private String productId;
	
	public WishedItem() {
		
	}
	
	public WishedItem(Integer customerId,String productId) {
		this.customerId=customerId;
		this.productId=productId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		WishedItem wishedItem = (WishedItem) o;
		return Objects.equals(id, wishedItem.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	

	
}
