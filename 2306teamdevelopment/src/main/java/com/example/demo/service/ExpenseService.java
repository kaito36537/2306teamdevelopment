package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.ExpenseEntity;
import com.example.demo.repository.ExpenseRepository;

@Service
@Transactional
public class ExpenseService {

	@Autowired
	private ExpenseRepository expenseRepository;
	/*コントラクタ*/	

	/*データベースから情報を全て持ってくるやつ*/
	public List<ExpenseEntity> findAll(){
	    return expenseRepository.findAll();
	    }
	/*データベースに情報を追加するやつ*/
	  public void addExpense(ExpenseEntity expenseEntity) {
		  expenseRepository.save(expenseEntity);
	  }
}