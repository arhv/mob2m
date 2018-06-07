package com.mob2m.hairdressing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mob2m.hairdressing.model.dao.ProductsReselling;
import com.mob2m.hairdressing.repository.ProductsResellingRepository;

@Service
public class ProductsResellingService {

	@Autowired
	private ProductsResellingRepository productsResellingRepository;

	//Delete an user
	public void delete(Long id) {
		productsResellingRepository.delete(id);
	}

	//All User
	public List<ProductsReselling> findAll() {
		return productsResellingRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	//Query specific ID
	public ProductsReselling findOne(Long id) {
		return productsResellingRepository.findOne(id);
	}

	//Add new or updated
	public ProductsReselling save(ProductsReselling productsResellingData) {
		return productsResellingRepository.saveAndFlush(productsResellingData);

	}


}
