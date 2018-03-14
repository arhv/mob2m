package com.mob2m.hairdressing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mob2m.hairdressing.model.dao.Expenses;
import com.mob2m.hairdressing.repository.ExpensesRepository;

@Service
public class ExpensesService {

	@Autowired
	private ExpensesRepository expensesRepository;

	//Delete an expense
	public void delete(Long id) {
		expensesRepository.delete(id);
	}

	//All expenses
	public List<Expenses> findAll() {
		return expensesRepository.findAll();
	}

	//Query specific ID
	public Expenses findOne(Long id) {
		return expensesRepository.findOne(id);
	}

	//Add new or updated an expense 
	public Expenses save(Expenses expenseData) {
		return expensesRepository.saveAndFlush(expenseData);
	}

}
