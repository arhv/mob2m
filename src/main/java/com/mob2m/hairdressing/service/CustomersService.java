package com.mob2m.hairdressing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mob2m.hairdressing.model.dao.Customers;
import com.mob2m.hairdressing.repository.CustomersRepository;

@Service
public class CustomersService {

	@Autowired
	private CustomersRepository customersRepository;


	public void delete(Long id) {
		customersRepository.delete(id);
	}


	public List<Customers> findAll() {
		return customersRepository.findAll(new Sort(Sort.Direction.DESC, "id"));
	}


	public Customers findOne(Long id) {
		return customersRepository.findOne(id);
	}


	public List<Customers> listAllCustomersJoinedCityState() {
		return customersRepository.listAllCustomers();
	}

	public Customers save(Customers customersData) {
		return customersRepository.saveAndFlush(customersData);

	}

}
