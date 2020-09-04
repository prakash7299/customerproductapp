package com.dxctraining.wisheditemmgt.wisheditem.util;

import org.springframework.stereotype.Component;

import com.dxctraining.wisheditemmgt.wisheditem.dto.WishedItemDto;
import com.dxctraining.wisheditemmgt.wisheditem.entities.WishedItem;





@Component
public class WishItemUtil {
	
	public WishedItemDto wishItemDto(WishedItem wishedItem,int customerId,String cname,String productId,String pname) {
		WishedItemDto dto=new WishedItemDto(wishedItem.getId(),customerId,productId);
		dto.setCname(cname);
		dto.setPname(pname);
		return dto;
	}

}
