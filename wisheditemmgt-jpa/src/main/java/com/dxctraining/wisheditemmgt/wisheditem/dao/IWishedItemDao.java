package com.dxctraining.wisheditemmgt.wisheditem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxctraining.wisheditemmgt.wisheditem.entities.WishedItem;


public interface IWishedItemDao extends JpaRepository<WishedItem,String>{
	List<WishedItem> findByCustomerId(Integer customerId);
 
}
