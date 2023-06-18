package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.UserRequest;
import com.example.demo.dto.UserUpdateRequest;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	/*
	 *マイページの表示
	 */
	@GetMapping("/user/mypage")
	public String displayMypage(Model model) {
		return "user/mypage";
	}
	
	/*
	 * ユーザー登録画面の表示
	 * @param model Model
	 * @return ユーザー新規登録画面
	 */
	@GetMapping("/user/registration")
	public String displayRegistration(Model model) {
		model.addAttribute("userRequest", new UserRequest());
		return "user/userRegistration";
	}

	/**
	   * ユーザー新規登録
	   * @param userRequest リクエストデータ
	   * @param model Model
	   * @return マイページ
	   */
	@PostMapping("/user/create")
	public String create(@ModelAttribute @Validated UserRequest userRequest, BindingResult result, Model model) {
		if (result.hasErrors()) {
			//入力チェックエラーの場合
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("validationError", errorList);
			return "user/UserRegistration";
		}
		//ユーザー情報の登録
		userService.create(userRequest);
		return "user/mypage";
	}

	/**
	   * ユーザー編集画面を表示
	   * @param id 表示するユーザーID
	   * @param model Model
	   * @return ユーザー編集画面
	   */
	@GetMapping("user/{user_id}/edit")
	public String displayEdit(@PathVariable Integer user_id, Model model) {
		UserEntity user = userService.findById(user_id);
		UserUpdateRequest userUpdateRequest = new UserUpdateRequest();
		userUpdateRequest.setUser_id(user.getUser_id());
		userUpdateRequest.setName(user.getName());
		userUpdateRequest.setFurigana(user.getFurigana());
		userUpdateRequest.setMail(user.getMail());
		userUpdateRequest.setPassword(user.getPassword());
		model.addAttribute("userUpdateRequest", userUpdateRequest);
		return "user/UserEdit";
	}

	/**
	   * ユーザー情報を更新
	   * @param id 表示するユーザーID
	   * @param model Model
	   */

	@PostMapping("/user/update")
	public String update(@Validated @ModelAttribute UserUpdateRequest userUpdateRequest, BindingResult result,Model model) {
		if (result.hasErrors()) {
			List<String> errorList = new ArrayList<String>();

			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("validationError", errorList);
			return "user/UserEdit";
		}
			//ユーザー情報の更新
			userService.update(userUpdateRequest);
			return "user/mypage";
//			return String.format("redirect:/user/%d", userUpdateRequest.getUser_id());
		}

}
