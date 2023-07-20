package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ExpenseRequest;
import com.example.demo.entity.ExpenseEntity;
import com.example.demo.repository.ExpenseRepository;

@Service

public class ExpenseregisterService {
	@Autowired
	private ExpenseRepository expenseRepository;

	/*データベースに登録する値を保持するインスタンス*/
	public void create(ExpenseRequest expenseRequest) {
		ExpenseEntity expenseEntity = new ExpenseEntity();
		/*画面から受け取った値をデータベースに保存するインスタンスに渡す*/
		expenseEntity.setUserId(expenseRequest.getUser_id());
		expenseEntity.setShinseiDay(expenseRequest.getShinsei_day());
		expenseEntity.setShinseiKoumoku(expenseRequest.getShinsei_koumoku());
		expenseEntity.setShinseiMoney(expenseRequest.getShinsei_money());
		expenseEntity.setRemarks(expenseRequest.getRemarks());
		/*データベースへ登録*/
		expenseRepository.save(expenseEntity);
	}

}
