package com.mob2m.hairdressing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mob2m.hairdressing.model.dao.CompanySubsidiaries;
import com.mob2m.hairdressing.repository.CompanySubsidiariesRepository;

@Service
public class CompanySubsidiariesService {

	@Autowired
	private CompanySubsidiariesRepository companySubsidiariesRepository;

	//Delete an user
	public void delete(Long id) {
		companySubsidiariesRepository.delete(id);
	}

	//All User
	public List<CompanySubsidiaries> findAll() {
		return companySubsidiariesRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	//Query specific ID
	public CompanySubsidiaries findOne(Long id) {
		return companySubsidiariesRepository.findOne(id);
	}

	public List<CompanySubsidiaries> listAllSubsidiariesJoinedCityState() {
		return companySubsidiariesRepository.listAllSubsidiaries();
	}

	//Add new or updated
	public CompanySubsidiaries save(CompanySubsidiaries companySubsidiaries) {
		return companySubsidiariesRepository.saveAndFlush(companySubsidiaries);

	}

}
