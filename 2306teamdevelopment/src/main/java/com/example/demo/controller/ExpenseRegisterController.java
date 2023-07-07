package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.ExpenseRequest;
import com.example.demo.service.ExpenseregisterService;


@Controller
public class ExpenseRegisterController{
	
	@Autowired
	private ExpenseregisterService expenseRegisterService;
	
	/*登録画面を表示*/
	@GetMapping("/ExpenseRegister")
	public String showExpense(Model model){
		model.addAttribute("expenseRequest", new ExpenseRequest());
		    return "ExpenseApplicationScreen";
	}

	
	@PostMapping("/ExpenseCreate")
    public String saveExpense(@ModelAttribute ExpenseRequest expenseRequest,BindingResult bindingResult, Model model){
        /*ユーザー情報の登録*/
		expenseRegisterService.insert(expenseRequest);
	    /*経費一覧に値を返す*/
		return "ExpenseList";
}
}