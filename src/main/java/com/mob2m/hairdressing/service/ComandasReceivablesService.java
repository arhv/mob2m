package com.mob2m.hairdressing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mob2m.hairdressing.model.dao.ComandasReceivables;
import com.mob2m.hairdressing.repository.ComandasReceivablesRepository;

@Service
public class ComandasReceivablesService {

	@Autowired
	private ComandasReceivablesRepository comandasReceivablesRepository;


	public void delete(Long id) {
		comandasReceivablesRepository.delete(id);
	}


	public List<ComandasReceivables> findAll() {
		return comandasReceivablesRepository.findAll(new Sort(Sort.Direction.DESC, "id"));
	}


	public ComandasReceivables findOne(Long id) {
		return comandasReceivablesRepository.findOne(id);
	}


	public List<ComandasReceivables> listAllComandasPaymentsSaved(Long comandaId) {
		return comandasReceivablesRepository.listComandasPaymentsSaved(comandaId);

	}

	public ComandasReceivables save(ComandasReceivables comandasReceivablesData) {
		return comandasReceivablesRepository.saveAndFlush(comandasReceivablesData);

	}
}
