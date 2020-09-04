package com.dxctraining.wisheditemmgt.wisheditem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxctraining.wisheditemmgt.wisheditem.dao.IWishedItemDao;
import com.dxctraining.wisheditemmgt.wisheditem.entities.WishedItem;
import com.dxctraining.wisheditemmgt.wisheditem.exceptions.WishedItemNotFoundException;



@Transactional
@Service
public class WishedItemServiceImpl implements IWishedItemService {
	@Autowired
	private IWishedItemDao dao;

	@Override
	public WishedItem findById(String id) {
		Optional<WishedItem> optional = dao.findById(id);
		boolean exist = optional.isPresent();
		if (!exist) {
			throw new WishedItemNotFoundException("wishedItem not found for id=" + id);
		}
		WishedItem wishedItem = optional.get();
		return wishedItem;
	}
	@Override
	public List<WishedItem> findByCustomerId(Integer customerId){
		List<WishedItem> wishedItem=dao.findByCustomerId(customerId);
		return wishedItem;
	}

	@Override
	public WishedItem add(WishedItem wishedItem) {
		String customerId=wishedItem.getCustomerId().toString();
		String productId=wishedItem.getProductId();
		String wishedId=customerId+productId;
		wishedItem.setId(wishedId);
		wishedItem = dao.save(wishedItem);
		return wishedItem;
	}

	@Override
	public void removeById(String id) {
		dao.deleteById(id);
	}
	
	@Override
	public WishedItem update(WishedItem wishedItem) {
		wishedItem = dao.save(wishedItem);
		return wishedItem;
	}

	@Override
	public List<WishedItem> allWishedItem() {
		List<WishedItem> allWishedItem = dao.findAll();
		return allWishedItem;
	}

}
