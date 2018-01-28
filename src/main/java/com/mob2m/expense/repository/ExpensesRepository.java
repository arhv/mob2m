package com.mob2m.expense.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mob2m.expense.model.ExpensesModel;

@Repository
public interface ExpensesRepository extends JpaRepository<ExpensesModel, Long> {

}
