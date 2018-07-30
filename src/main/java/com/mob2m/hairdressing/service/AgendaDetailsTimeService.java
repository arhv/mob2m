package com.mob2m.hairdressing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mob2m.hairdressing.model.dao.AgendaDetailsTime;
import com.mob2m.hairdressing.repository.AgendaDetailsTimeRepository;

@Service
public class AgendaDetailsTimeService {

	@Autowired
	private AgendaDetailsTimeRepository agendaDetailsTimeRepository;

	//Delete an user
	public void delete(Long id) {
		agendaDetailsTimeRepository.delete(id);
	}

	//All User
	public List<AgendaDetailsTime> findAll() {
		return agendaDetailsTimeRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	//Query specific ID
	public AgendaDetailsTime findOne(Long id) {
		return agendaDetailsTimeRepository.findOne(id);
	}


	//Add new or updated
	public AgendaDetailsTime save(AgendaDetailsTime agendaDetailsTimeData) {
		return agendaDetailsTimeRepository.saveAndFlush(agendaDetailsTimeData);

	}

}
