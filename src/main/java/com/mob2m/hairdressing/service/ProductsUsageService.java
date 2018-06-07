package com.mob2m.hairdressing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mob2m.hairdressing.model.dao.ProductsUsage;
import com.mob2m.hairdressing.repository.ProductsUsageRepository;

@Service
public class ProductsUsageService {

	@Autowired
	private ProductsUsageRepository productsUsageRepository;

	//Delete an user
	public void delete(Long id) {
		productsUsageRepository.delete(id);
	}

	//All User
	public List<ProductsUsage> findAll() {
		return productsUsageRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	//Query specific ID
	public ProductsUsage findOne(Long id) {
		return productsUsageRepository.findOne(id);
	}

	//Add new or updated
	public ProductsUsage save(ProductsUsage productsUsageData) {
		return productsUsageRepository.saveAndFlush(productsUsageData);

	}


}
