package com.mob2m.hairdressing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mob2m.hairdressing.model.dao.ComandasExpensesServices;
import com.mob2m.hairdressing.repository.ComandasExpensesServicesRepository;

@Service
public class ComandasExpensesServicesService {

	@Autowired
	private ComandasExpensesServicesRepository comandasExpensesRepository;

	//Delete an user
	public void delete(Long id) {
		comandasExpensesRepository.delete(id);
	}

	//All User
	public List<ComandasExpensesServices> findAll() {
		return comandasExpensesRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	//Query specific ID
	public ComandasExpensesServices findOne(Long id) {
		return comandasExpensesRepository.findOne(id);
	}

	//Add new or updated
	public ComandasExpensesServices save(ComandasExpensesServices comandasExpensesServicesData) {
		return comandasExpensesRepository.saveAndFlush(comandasExpensesServicesData);

	}


}
