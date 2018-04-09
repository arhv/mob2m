package com.mob2m.hairdressing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mob2m.hairdressing.model.dao.Services;
import com.mob2m.hairdressing.repository.ServicesRepository;

@Service
public class ServicesService {

	@Autowired
	private ServicesRepository servicesRepository;

	//Delete an user
	public void delete(Long id) {
		servicesRepository.delete(id);
	}

	//All User
	public List<Services> findAll() {
		return servicesRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	//Query specific ID
	public Services findOne(Long id) {
		return servicesRepository.findOne(id);
	}

	//Add new or updated
	public Services save(Services servicesData) {
		return servicesRepository.saveAndFlush(servicesData);

	}


}
