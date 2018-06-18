package com.mob2m.hairdressing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mob2m.hairdressing.model.dao.ComandasReceivablesDetails;
import com.mob2m.hairdressing.repository.ComandasReceivablesDetailsRepository;

@Service
public class ComandasReceivablesDetailsService {

	@Autowired
	private ComandasReceivablesDetailsRepository comandasReceivablesDetailsRepository;


	public void delete(Long id) {
		comandasReceivablesDetailsRepository.delete(id);
	}


	public List<ComandasReceivablesDetails> findAll() {
		return comandasReceivablesDetailsRepository.findAll(new Sort(Sort.Direction.DESC, "id"));
	}


	public ComandasReceivablesDetails findOne(Long id) {
		return comandasReceivablesDetailsRepository.findOne(id);
	}


	public ComandasReceivablesDetails save(ComandasReceivablesDetails comandasReceivablesDetailsData) {
		return comandasReceivablesDetailsRepository.saveAndFlush(comandasReceivablesDetailsData);

	}
	
	public List<ComandasReceivablesDetails> listAllRemainingComandaPayment(Long id) {
		return comandasReceivablesDetailsRepository.listRemainingComandaPayment(id);

	}

}
