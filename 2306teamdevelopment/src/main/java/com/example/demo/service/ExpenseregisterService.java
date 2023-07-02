package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.ExpenseRequest;
import com.example.demo.repository.ExpenseRepository;

@Service
@Transactional

public class ExpenseregisterService{
	@Autowired
	private ExpenseRepository expenseRepository;
	
	
	
	  /*データベースに登録する値を保持するインスタンス*/
	  public void insert(ExpenseRequest expenseRequest) {
		  
		  ExpenseRequest expenserequest = new ExpenseRequest();
		  
			/*画面から受け取った値をデータベースに保存するインスタンスに渡す*/		  
		  expenserequest.setUser_id(expenseRequest.getUser_id());
		  expenserequest.setShinsei_day(expenseRequest.getShinsei_day());
		  expenserequest.setShinsei_koumoku(expenseRequest.getShinsei_koumoku());
		  expenserequest.setKeihi_id(expenseRequest.getKeihi_id());
		  expenserequest.setShinsei_money(expenseRequest.getShinsei_money());
		  expenserequest.setBikou(expenseRequest.getBikou());
		  
		  /*データベースへ登録*/
		  expenseRepository.save(expenserequest);
	  }

	}

