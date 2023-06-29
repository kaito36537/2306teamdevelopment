package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.ExpenseRequest;
import com.example.demo.entity.ExpenseEntity;
import com.example.demo.repository.ExpenseRepository;

@Service
@Transactional

public class ExpenseregisterService{
	@Autowired
	private ExpenseRepository expenseRepository;
	
	  /*データベースに登録する値を保持するインスタンス*/
	  public void insert(ExpenseEntity expenseentity) {
		  
		/*画面から受け取った値をデータベースに保存するインスタンスに渡す*/
		  ExpenseEntity registerEntity = new ExpenseEntity();
		  registerEntity.setUserId(expenseentity.getUserId());
		  registerEntity.setShinsei_Day(expenseentity.getShinsei_Day());
		  registerEntity.setShinsei_Koumoku(expenseentity.getShinsei_Koumoku());
		  registerEntity.setKeihi_Id(expenseentity.getKeihi_Id());
		  registerEntity.setShinsei_Money(expenseentity.getShinsei_Money());
		  registerEntity.setBikou(expenseentity.getBikou());
		  
		  /*データベースへ登録*/
		  expenseRepository.save(expenseentity);
	  }

	public void insert(ExpenseRequest expenseRequest) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	
}