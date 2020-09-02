package com.dxctraining.wisheditemmgt.wisheditem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxctraining.wisheditemmgt.wisheditem.entities.WishedItem;


public interface IWishedItemDao extends JpaRepository<WishedItem,String>{
 
}
