package com.dxctraining.wisheditemmgt.wisheditem.controller;


import java.util.ArrayList;
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
import org.springframework.web.client.RestTemplate;


import com.dxctraining.wisheditemmgt.wisheditem.dto.CreateWishedItemRequest;
import com.dxctraining.wisheditemmgt.wisheditem.dto.CustomerDto;
import com.dxctraining.wisheditemmgt.wisheditem.dto.ProductDto;
import com.dxctraining.wisheditemmgt.wisheditem.dto.UpdateWishedItemRequest;
import com.dxctraining.wisheditemmgt.wisheditem.dto.WishedItemDto;
import com.dxctraining.wisheditemmgt.wisheditem.entities.WishedItem;
import com.dxctraining.wisheditemmgt.wisheditem.service.IWishedItemService;
import com.dxctraining.wisheditemmgt.wisheditem.util.WishItemUtil;



@RestController
@RequestMapping("/wisheditems")
public class WishedItemRestController {

	@Autowired
	private IWishedItemService service;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WishItemUtil wishUtil;

	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public WishedItemDto createWishItem(@RequestBody CreateWishedItemRequest data) {
		WishedItem wishedItem = new WishedItem(data.getCustomerId(),data.getProductId());
		wishedItem = service.add(wishedItem);
		CustomerDto customer = fetchAllCustomersById(data.getCustomerId());
		ProductDto product=fetchAllProductsById(data.getProductId());
		WishedItemDto response=wishUtil.wishItemDto(wishedItem, customer.getId(), customer.getCname(),product.getId(),product.getPname());
		return response;
	}

	@GetMapping("/get/{id}")
	public WishedItemDto findById(@PathVariable("id") String id) {
		WishedItem wishedItem = service.findById(id);
		CustomerDto customer = fetchAllCustomersById(wishedItem.getCustomerId());
		ProductDto product=fetchAllProductsById(wishedItem.getProductId());
		WishedItemDto dto=wishUtil.wishItemDto(wishedItem, customer.getId(), customer.getCname(), product.getId(), product.getPname());
		return dto;
	}
	
	@GetMapping("/find/{customerId}")
	public List<WishedItemDto> findById(@PathVariable("customerId") Integer customerId) {
		List<WishedItem> wishedItems = service.findByCustomerId(customerId);
		List<WishedItemDto> dtoList=new ArrayList<>();
		for(WishedItem wisheditem:wishedItems) {
		CustomerDto customer = fetchAllCustomersById(wisheditem.getCustomerId());
		ProductDto product=fetchAllProductsById(wisheditem.getProductId());
		WishedItemDto dto=wishUtil.wishItemDto(wisheditem, customer.getId(), customer.getCname(), product.getId(), product.getPname());
		dtoList.add(dto);
		}
		return dtoList;
	}

	@PutMapping("/update")
	public WishedItemDto updateWishedItem(@RequestBody UpdateWishedItemRequest data) {
		String id=data.getId();
		WishedItem wishedItem=service.findById(id);
		wishedItem.setId(id);
		wishedItem=service.update(wishedItem);
		CustomerDto customer=fetchAllCustomersById(wishedItem.getCustomerId());
		ProductDto product=fetchAllProductsById(wishedItem.getProductId());
		WishedItemDto dto=wishUtil.wishItemDto(wishedItem, customer.getId(), customer.getCname(), product.getId(), product.getPname());
	    return dto;
	}

	@DeleteMapping("/delete/{id}")
	public void deleteWishedItemrById(@PathVariable("id") String id) {
		service.removeById(id);
	}

	public CustomerDto fetchAllCustomersById(int customerId) {
        String url = "http://customermgt/customers/get/" + customerId;
        CustomerDto dto = restTemplate.getForObject(url, CustomerDto.class);
        return dto;
    }
	
	public ProductDto fetchAllProductsById(String productId) {
        String url = "http://productmgt/products/get/" + productId;
        ProductDto dto = restTemplate.getForObject(url, ProductDto.class);
        return dto;
    }

}
