package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ExpenseRequest;
import com.example.demo.entity.ExpenseEntity;
import com.example.demo.repository.ExpenseRepository;

@Service
//@Transactional

public class ExpenseregisterService {
	@Autowired
	private ExpenseRepository expenseRepository;

	/*データベースに登録する値を保持するインスタンス*/
	public void insert(ExpenseRequest expenseRequest) {

		ExpenseEntity expenseEntity = new ExpenseEntity();
		/*画面から受け取った値をデータベースに保存するインスタンスに渡す*/
		expenseEntity.setUser_id(expenseRequest.getUser_id());
		expenseEntity.setShinsei_day(expenseRequest.getShinsei_day());
		expenseEntity.setShinsei_koumoku(expenseRequest.getShinsei_koumoku());
		expenseEntity.setKeihi_id(expenseRequest.getKeihi_id());
		expenseEntity.setShinsei_money(expenseRequest.getShinsei_money());
		expenseEntity.setBikou(expenseRequest.getBikou());

		/*データベースへ登録*/
		expenseRepository.save(expenseEntity);
	}

}
