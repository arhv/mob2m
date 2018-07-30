package com.mob2m.hairdressing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mob2m.hairdressing.model.dao.AgendaDate;
import com.mob2m.hairdressing.repository.AgendaDateRepository;

@Service
public class AgendaDateService {

	@Autowired
	private AgendaDateRepository agendaDateRepository;

	//Delete an user
	public void delete(Long id) {
		agendaDateRepository.delete(id);
	}

	//All User
	public List<AgendaDate> findAll() {
		return agendaDateRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	//Query specific ID
	public AgendaDate findOne(Long id) {
		return agendaDateRepository.findOne(id);
	}


	public List<AgendaDate> listAllAgendaDate() {
		return agendaDateRepository.listAllAgenda();

	}

	//Add new or updated
	public AgendaDate save(AgendaDate agendaDateData) {
		return agendaDateRepository.saveAndFlush(agendaDateData);

	}

}
