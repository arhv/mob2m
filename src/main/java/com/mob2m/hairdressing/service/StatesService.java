package com.mob2m.hairdressing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mob2m.hairdressing.model.dao.States;
import com.mob2m.hairdressing.repository.StatesRepository;

@Service
public class StatesService {

	@Autowired
	private StatesRepository stateRepository;

	//Delete an user
	public void delete(Long id) {
		stateRepository.delete(id);
	}

	//All User
	public List<States> findAll() {
		return stateRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	//Query specific ID
	public States findOne(Long id) {
		return stateRepository.findOne(id);
	}

	//Add new or updated
	public States save(States statesData) {
		return stateRepository.saveAndFlush(statesData);

	}


}
