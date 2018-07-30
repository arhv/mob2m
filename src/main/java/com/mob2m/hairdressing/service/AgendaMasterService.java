package com.mob2m.hairdressing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mob2m.hairdressing.model.dao.AgendaMaster;
import com.mob2m.hairdressing.repository.AgendaMasterRepository;

@Service
public class AgendaMasterService {

	@Autowired
	private AgendaMasterRepository agendaMasterRepository;

	//Delete an user
	public void delete(Long id) {
		agendaMasterRepository.delete(id);
	}

	//All User
	public List<AgendaMaster> findAll() {
		return agendaMasterRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	//Query specific ID
	public AgendaMaster findOne(Long id) {
		return agendaMasterRepository.findOne(id);
	}


	//Add new or updated
	public AgendaMaster save(AgendaMaster agendaMasterData) {
		return agendaMasterRepository.saveAndFlush(agendaMasterData);

	}

}
