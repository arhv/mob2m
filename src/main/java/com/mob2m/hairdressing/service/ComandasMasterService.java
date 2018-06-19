package com.mob2m.hairdressing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mob2m.hairdressing.model.dao.ComandasMaster;
import com.mob2m.hairdressing.repository.ComandasMasterRepository;

@Service
public class ComandasMasterService {

	@Autowired
	private ComandasMasterRepository comandasMasterRepository;


	public void delete(Long id) {
		comandasMasterRepository.delete(id);
	}


	public List<ComandasMaster> findAll() {
		return comandasMasterRepository.findAll(new Sort(Sort.Direction.DESC, "id"));
	}


	public ComandasMaster findOne(Long id) {
		return comandasMasterRepository.findOne(id);
	}

	public List<ComandasMaster> listAllComandasOpened(String status) {
		return comandasMasterRepository.listComandasOpened(status);
	}

	public ComandasMaster save(ComandasMaster comandasMasterData) {
		return comandasMasterRepository.saveAndFlush(comandasMasterData);

	}

}
