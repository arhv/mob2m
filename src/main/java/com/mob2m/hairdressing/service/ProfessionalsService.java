package com.mob2m.hairdressing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mob2m.hairdressing.model.dao.Professionals;
import com.mob2m.hairdressing.repository.ProfessionalsRepository;

@Service
public class ProfessionalsService {

	@Autowired
	private ProfessionalsRepository professionalsRepository;


	public void delete(Long id) {
		professionalsRepository.delete(id);
	}


	public List<Professionals> findAll() {
		return professionalsRepository.findAll(new Sort(Sort.Direction.DESC, "id"));
	}


	public Professionals findOne(Long id) {
		return professionalsRepository.findOne(id);
	}


	/*public List<Professionals> listAllProfessionalsJoinedCityState() {
		return professionalsRepository.listAllProfessionals();
	}*/

	public Professionals save(Professionals professionalsData) {
		return professionalsRepository.saveAndFlush(professionalsData);

	}

}
