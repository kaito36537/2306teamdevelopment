package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dto.UserRequest;
import com.example.demo.service.UserService;

@Controller
public class UserController {
	
	/*
	 * Service
	 */
	@Autowired
	private UserService userService;
	
	
	/*df
	 * ユーザー登録画面の表示
	 * @param model Model
	 * @return ユーザー新規登録画面
	 */
	@GetMapping(value = "/user/register")
	public String userRegistration(Model model) {
		model.addAttribute("userRequest", new UserRequest());
		return "user/UserEdit";
	}
	
}
