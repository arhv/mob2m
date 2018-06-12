package com.mob2m.hairdressing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mob2m.hairdressing.model.dao.ComandasDetailsServices;
import com.mob2m.hairdressing.repository.ComandasDetailsServicesRepository;

@Service
public class ComandasDetailsService {

	@Autowired
	private ComandasDetailsServicesRepository comandasDetailsServicesRepository;


	public void delete(Long id) {
		comandasDetailsServicesRepository.delete(id);
	}


	public List<ComandasDetailsServices> findAll() {
		return comandasDetailsServicesRepository.findAll(new Sort(Sort.Direction.DESC, "id"));
	}


	public ComandasDetailsServices findOne(Long id) {
		return comandasDetailsServicesRepository.findOne(id);
	}

	public List<ComandasDetailsServices> listAllComandasDetailsServicesById(Long id) {
		return comandasDetailsServicesRepository.listAllComandasDetailsServices(id);

	}

	public ComandasDetailsServices save(ComandasDetailsServices comandasDetailsServicesData) {
		return comandasDetailsServicesRepository.saveAndFlush(comandasDetailsServicesData);

	}

	/*public int sumAllComandasDetailsServicesById(Long id) {
		return comandasDetailsServicesRepository.summAllComandasDetailsServices(id);
	
	}*/

}
