package com.mob2m.hairdressing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mob2m.hairdressing.model.dao.UserCompany;
import com.mob2m.hairdressing.repository.UserCompanyRepository;

@Service
public class UserCompanyService {

	@Autowired
	private UserCompanyRepository userCompanyRepository;


	public void delete(Long id) {
		userCompanyRepository.delete(id);
	}


	public List<UserCompany> findAll() {
		return userCompanyRepository.findAll(new Sort(Sort.Direction.DESC, "id"));
	}


	public UserCompany findOne(Long id) {
		return userCompanyRepository.findOne(id);
	}


	public UserCompany save(UserCompany userCompanyData) {
		return userCompanyRepository.saveAndFlush(userCompanyData);

	}

}
