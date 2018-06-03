package com.mob2m.hairdressing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mob2m.hairdressing.model.dao.Suppliers;
import com.mob2m.hairdressing.repository.SuppliersRepository;

@Service
public class SuppliersService {

	@Autowired
	private SuppliersRepository suppliersRepository;

	//Delete an user
	public void delete(Long id) {
		suppliersRepository.delete(id);
	}

	//All User
	public List<Suppliers> findAll() {
		return suppliersRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	//Query specific ID
	public Suppliers findOne(Long id) {
		return suppliersRepository.findOne(id);
	}

	//Add new or updated
	public Suppliers save(Suppliers suppliersData) {
		return suppliersRepository.saveAndFlush(suppliersData);

	}


}
