package com.mob2m.hairdressing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mob2m.hairdressing.model.dao.AgendaSubsidiary;
import com.mob2m.hairdressing.repository.AgendaSubsidiaryRepository;

@Service
public class AgendaSubsidiaryService {

	@Autowired
	private AgendaSubsidiaryRepository agendaSubsidiaryRepository;

	//Delete an user
	public void delete(Long id) {
		agendaSubsidiaryRepository.delete(id);
	}

	//All User
	public List<AgendaSubsidiary> findAll() {
		return agendaSubsidiaryRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	//Query specific ID
	public AgendaSubsidiary findOne(Long id) {
		return agendaSubsidiaryRepository.findOne(id);
	}


	//Add new or updated
	public AgendaSubsidiary save(AgendaSubsidiary agendaSubsidiaryData) {
		return agendaSubsidiaryRepository.saveAndFlush(agendaSubsidiaryData);

	}

}
