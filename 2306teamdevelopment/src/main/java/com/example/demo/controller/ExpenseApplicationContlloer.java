package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
/**
 * ユーザー情報 Controller
 */
@Controller
public class ExpenseController {
	 
	 @Autowired
	  private ExpenseService expenseService;
	 
	  @GetMapping(value = "/user/list")
	  public String displayList(Model model) {
	    List<User> userlist = userService.searchAll();
	    model.addAttribute("userlist", userlist);
	    return "user/list";
	  }
}