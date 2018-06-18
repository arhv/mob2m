package com.mob2m.hairdressing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mob2m.hairdressing.model.dao.ComandasPaymentsTypes;
import com.mob2m.hairdressing.repository.ComandasPaymentsTypesRepository;

@Service
public class ComandasPaymentsTypesService {

	@Autowired
	private ComandasPaymentsTypesRepository paymentsTypesRepository;


	public void delete(Long id) {
		paymentsTypesRepository.delete(id);
	}


	public List<ComandasPaymentsTypes> findAll() {
		return paymentsTypesRepository.findAll(new Sort(Sort.Direction.DESC, "id"));
	}


	public ComandasPaymentsTypes findOne(Long id) {
		return paymentsTypesRepository.findOne(id);
	}


	public ComandasPaymentsTypes save(ComandasPaymentsTypes paymentsTypesData) {
		return paymentsTypesRepository.saveAndFlush(paymentsTypesData);

	}

}
