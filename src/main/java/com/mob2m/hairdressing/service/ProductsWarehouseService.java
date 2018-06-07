package com.mob2m.hairdressing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mob2m.hairdressing.model.dao.ProductsWarehouse;
import com.mob2m.hairdressing.repository.ProductsWarehouseRepository;

@Service
public class ProductsWarehouseService {

	@Autowired
	private ProductsWarehouseRepository productsWarehouseRepository;

	//Delete an user
	public void delete(Long id) {
		productsWarehouseRepository.delete(id);
	}

	//All User
	public List<ProductsWarehouse> findAll() {
		return productsWarehouseRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	//Query specific ID
	public ProductsWarehouse findOne(Long id) {
		return productsWarehouseRepository.findOne(id);
	}

	//Add new or updated
	public ProductsWarehouse save(ProductsWarehouse productsWarehouseData) {
		return productsWarehouseRepository.saveAndFlush(productsWarehouseData);

	}


}
