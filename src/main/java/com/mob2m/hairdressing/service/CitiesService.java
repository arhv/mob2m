package com.mob2m.hairdressing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mob2m.hairdressing.model.dao.Cities;
import com.mob2m.hairdressing.repository.CitiesRepository;

@Service
public class CitiesService {

	@Autowired
	private CitiesRepository citiesRepository;

	//Delete an user
	public void delete(Long id) {
		citiesRepository.delete(id);
	}

	//All User
	public List<Cities> findAll() {
		return citiesRepository.findAll(new Sort(Sort.Direction.DESC, "id"));
	}

	//Query specific ID
	public Cities findOne(Long estados_cod_estados) {
		return citiesRepository.findOne(estados_cod_estados);
	}

	//Add new or updated
	public Cities save(Cities citiesData) {
		return citiesRepository.saveAndFlush(citiesData);

	}

	public List<Cities> stateCode(int userState) {
		return citiesRepository.getCitiesNames(userState);
	}

	public List<Cities> stateCodeSubsidiaries(int companySubsidiariesState) {
		return citiesRepository.getCitiesNamesSubsidiaries(companySubsidiariesState);
	}
}
