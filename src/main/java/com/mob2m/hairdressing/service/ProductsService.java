package com.mob2m.hairdressing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mob2m.hairdressing.model.dao.Products;
import com.mob2m.hairdressing.repository.ProductsRepository;

@Service
public class ProductsService {

	@Autowired
	private ProductsRepository productsRepository;

	//Delete an user
	public void delete(Long id) {
		productsRepository.delete(id);
	}

	//All User
	public List<Products> findAll() {
		return productsRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	//Query specific ID
	public Products findOne(Long id) {
		return productsRepository.findOne(id);
	}

	//Add new or updated
	public Products save(Products productsData) {
		return productsRepository.saveAndFlush(productsData);

	}


}
