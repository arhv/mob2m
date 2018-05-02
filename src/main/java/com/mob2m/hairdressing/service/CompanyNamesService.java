package com.mob2m.hairdressing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mob2m.hairdressing.model.dao.CompanyNames;
import com.mob2m.hairdressing.repository.CompanyNamesRepository;

@Service
public class CompanyNamesService {

	@Autowired
	private CompanyNamesRepository companyNamesRepository;

	//Delete an user
	public void delete(Long id) {
		companyNamesRepository.delete(id);
	}

	//All User
	public List<CompanyNames> findAll() {
		return companyNamesRepository.findAll(new Sort(Sort.Direction.DESC, "id"));
	}

	//Query specific ID
	public CompanyNames findOne(Long id) {
		return companyNamesRepository.findOne(id);
	}

	//Add new or updated
	public CompanyNames save(CompanyNames companyNames) {
		return companyNamesRepository.saveAndFlush(companyNames);

	}


}
