package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.ExpenseEntity;
import com.example.demo.repository.ExpenseRepository;

@Service
@Transactional

public class ExpenseregisterService{
	@SuppressWarnings("unused")
	@Autowired
	private ExpenseRepository expenseRepository;
	
	
	  public void create(ExpenseEntity expenseRegister) {
		  
		  
		  ExpenseEntity registerEntity = new ExpenseEntity();
		  registerEntity.setUserId(expenseRegister.getUserId());
		  registerEntity.setShinsei_Day(expenseRegister.getShinsei_Day());
		  registerEntity.setShinsei_Koumoku(expenseRegister.getShinsei_Koumoku());
		  registerEntity.setKeihi_Id(expenseRegister.getKeihi_Id());
		  registerEntity.setShinsei_Money(expenseRegister.getShinsei_Money());
		  registerEntity.setBikou(expenseRegister.getBikou());
	
	  }
	
}