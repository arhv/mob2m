package com.mob2m.hairdressing.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mob2m.hairdressing.model.dao.User;
import com.mob2m.hairdressing.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository UserRepository;

	public List<String> checkValidUserEmail (String email) {
		return UserRepository.checkUserEmailExist(email);
	}

	public List<String> checkValidUsername (String username) {
		return UserRepository.checkUsernameExist(username);
	}

	//Delete an user
	public void delete(Long id) {
		UserRepository.delete(id);
	}

	//All User
	public List<User> findAll() {
		return UserRepository.findAll(new Sort(Sort.Direction.DESC, "id"));
	}

	//Query specific ID
	public User findOne(Long id) {
		return UserRepository.findOne(id);
	}

	//Add new or updated
	public User save(User userData) {
		return UserRepository.saveAndFlush(userData);

	}

	public int update(Long id, Boolean active, Date insertdate, String insertby, String email, String name, String phonenumber, String address,
			String zipCode, int cityName, int stateName) {
		return UserRepository.updateUser(id, active, insertdate, insertby, email, name, phonenumber, address, zipCode, cityName, stateName);
	}
}
