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
	public List<ExpenseEntity> searchAll(){
	    return expenseRepository.findAll();
	    }
}
	/*データベースに情報を追加するやつ*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	  public void create(ExpenseRequest expenseRequest) {
		    Date now = new Date();
		    User user = new User();
		    user.setUser_ID(expenseRequest.getUser_ID());
		    user.setShinsei_Day(now);
		    user.setKoumoku(expenseRequest.getAddress());
		    user.setKeihi_ID(expenseRequest.getName());
		    user.Money(expenseRequest.getName());
		    user.setBikou(expenseRequest.getPhone());
		    
		    expenseRepository.save(user);
		  }
		}
	*/