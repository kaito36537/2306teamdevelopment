package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	  @RequestMapping(value = "/Expense/list", method = RequestMethod.GET)
	  public String displayList(Model model) {
	    List<ExpenseEntity> expenselist = expenseService.searchAll();
	    model.addAttribute("expenselist", expenselist);
	    return "/Expense list/Expense list";
	  }
	  
	  /**経費申請画面を表示*/
	 /**
	  @GetMapping(value = "/expense/add")
	  public String displayAdd(Model model) {
	    model.addAttribute("userRequest", new UserRequest());
	    return "Expense list/Expense list";
	  }
	 */
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 /**
	 @GetMapping
	 public String expenseregister(Model model) {
		List<ExpenseEntity> expense = expenseService.findAll();
		model.addAttribute("ExpenseService",expense);
		 return "expenselist";
	  }
	  */
	  
	  
	 /*経費一覧画面を表示*/
	 /**
	 @RequestMapping(value = "Expense/list",method = RequestMethod.GET)
	 public String ExpenseList(Model model) {
		 List<keihi_tb> expenselist = expenseService.searchAll():
			 model.addAttribute("expenselist"), expenselist);
			 return"Expense list/Expense list";
	 }
	 */
	  
	  
	 /*経費申請画面を表示*/
	 /**
	  @GetMapping(value = "/Expense/register")
	  public String displayAdd(Model model) {
	    model.addAttribute("userRequest", new Expense
	    	Request());
	    return "user/add";
	  }
	  */
}