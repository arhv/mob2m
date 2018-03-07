package com.mob2m.hairdressing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mob2m.hairdressing.model.User;
import com.mob2m.hairdressing.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository UserRepository;

	//Delete an expense
	public void delete(Long id) {
		UserRepository.delete(id);
	}

	//All User
	public List<User> findAll() {
		return UserRepository.findAll();
	}

	//Query specific ID
	public User findOne(Long id) {
		return UserRepository.findOne(id);
	}

	//Add new or updated an expense
	public User save(User userData) {
		return UserRepository.saveAndFlush(userData);
	}

}
