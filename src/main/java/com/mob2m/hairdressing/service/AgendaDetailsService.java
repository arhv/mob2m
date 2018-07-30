package com.mob2m.hairdressing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mob2m.hairdressing.model.dao.AgendaDetails;
import com.mob2m.hairdressing.repository.AgendaDetailsRepository;

@Service
public class AgendaDetailsService {

	@Autowired
	private AgendaDetailsRepository agendaDetailsRepository;

	//Delete an user
	public void delete(Long id) {
		agendaDetailsRepository.delete(id);
	}

	//All User
	public List<AgendaDetails> findAll() {
		return agendaDetailsRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	//Query specific ID
	public AgendaDetails findOne(Long id) {
		return agendaDetailsRepository.findOne(id);
	}


	//Add new or updated
	public AgendaDetails save(AgendaDetails agendaDetailsData) {
		return agendaDetailsRepository.saveAndFlush(agendaDetailsData);

	}

}
