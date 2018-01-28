package com.mob2m.expense.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mob2m.expense.model.ExpensesModel;
import com.mob2m.expense.repository.ExpensesRepository;

@Service
public class ExpensesService {

	@Autowired
	private ExpensesRepository expensesRepository;

	//All expenses
	public List<ExpensesModel> findAll() {
		return expensesRepository.findAll();
	}

	//Query specific ID
	public ExpensesModel findOne(Long id) {
		return expensesRepository.findOne(id);
	}

	//Add new or updated an expense 
	public ExpensesModel save(ExpensesModel post) {
		return expensesRepository.saveAndFlush(post);
	}

	//Delete an expense
	public void delete(Long id) {
		expensesRepository.delete(id);
	}

}
