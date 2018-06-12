package com.mob2m.hairdressing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mob2m.hairdressing.model.dao.ComandasDetailsProductsUsage;
import com.mob2m.hairdressing.repository.ComandasDetailsProductsUsageRepository;

@Service
public class ComandasDetailsProductsUsageService {

	@Autowired
	private ComandasDetailsProductsUsageRepository comandasDetailsProductsUsageRepository;


	public void delete(Long id) {
		comandasDetailsProductsUsageRepository.delete(id);
	}


	public List<ComandasDetailsProductsUsage> findAll() {
		return comandasDetailsProductsUsageRepository.findAll(new Sort(Sort.Direction.DESC, "id"));
	}


	public ComandasDetailsProductsUsage findOne(Long id) {
		return comandasDetailsProductsUsageRepository.findOne(id);
	}

	public List<ComandasDetailsProductsUsage> listAllComandasDetailsProductsUsagesById(Long id) {
		return comandasDetailsProductsUsageRepository.listAllComandasDetailsProductsUsage(id);

	}

	public ComandasDetailsProductsUsage save(ComandasDetailsProductsUsage comandasDetailsServicesData) {
		return comandasDetailsProductsUsageRepository.saveAndFlush(comandasDetailsServicesData);

	}

	/*public int sumAllComandasDetailsServicesById(Long id) {
		return comandasDetailsServicesRepository.summAllComandasDetailsServices(id);

	}*/

}
