package com.dxctraining.wisheditemmgt.wisheditem.service;

import java.util.List;

import com.dxctraining.wisheditemmgt.wisheditem.entities.WishedItem;




public interface IWishedItemService {
	WishedItem findById(String id);
    WishedItem add(WishedItem wishedItem);
    WishedItem update(WishedItem wishedItem);
    void removeById(String id);
    List<WishedItem> allWishedItem();
    List<WishedItem> findByCustomerId(Integer customerId);
}
