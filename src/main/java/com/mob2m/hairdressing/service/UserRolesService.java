package com.mob2m.hairdressing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mob2m.hairdressing.model.dao.UserRoles;
import com.mob2m.hairdressing.repository.UserRolesRepository;

@Service
public class UserRolesService {

	@Autowired
	private UserRolesRepository userRolesRepository;


	public void delete(Long id) {
		userRolesRepository.delete(id);
	}


	public List<UserRoles> findAll() {
		return userRolesRepository.findAll(new Sort(Sort.Direction.DESC, "id"));
	}


	public UserRoles findOne(Long id) {
		return userRolesRepository.findOne(id);
	}


	public UserRoles save(UserRoles userRolesData) {
		return userRolesRepository.saveAndFlush(userRolesData);

	}

}
