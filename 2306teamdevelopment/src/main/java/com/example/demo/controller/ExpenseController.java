package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.ExpenseEntity;
import com.example.demo.service.ExpenseService;

/**
 * ユーザー情報 Controller
 */
@Controller
     public class ExpenseController {
	
	 @Autowired
	  private ExpenseService expenseService;
	 
	 /**経費一覧画面を表示*/
	  @GetMapping("/Expense/list")
	  public String expenseList(Model model) {
	    List<ExpenseEntity> expenselist = expenseService.findAll();
	    model.addAttribute("expenseList", expenselist);
	    return "Expense list";
	  }
	  
}