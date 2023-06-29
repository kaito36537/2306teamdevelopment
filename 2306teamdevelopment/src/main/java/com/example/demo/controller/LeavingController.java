package com.example.demo.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.LeavingRequest;
import com.example.demo.entity.LeavingEntity;
import com.example.demo.service.LeavingService;

public class LeavingController {

	@Autowired
	private LeavingService leavingService;
	
	@GetMapping("/Leaving")
	public String showLeaving(Model model) {
        model.addAttribute("LeavingRequest", new LeavingRequest());
        model.addAttribute("Leaving", new LeavingEntity()); 
        return "Leaving"; // 出勤報告入力画面のテンプレート名を返す
    }
	@PostMapping("/create")
    public String createUser(@ModelAttribute @Validated LeavingRequest LeavinggRequest, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getFieldErrors());
            return "Leaving"; // エラーメッセージを表示するために入力フォームのテンプレートにリダイレクト
        }
		return "redirect:/success";// 成功時のリダイレクト先
	}
	 @PostMapping("/Leaving/submit")
	    public String submitLeavingForm(@ModelAttribute("Leaving") @Validated LeavingEntity Leaving, BindingResult bindingResult, Model model) {
	        Leaving.setLeavingDate(LocalDate.now());
	        if (bindingResult.hasErrors()) {
	            model.addAttribute("errors", bindingResult.getFieldErrors());
	            return "Leaving"; // エラーメッセージを表示するために入力フォームのテンプレートにリダイレクト
	        }

	        // 出勤申請情報をデータベースに保存
	        leavingService.createLeavingReport(Leaving);
	        return "redirect:/mypage"; // マイページにリダイレクト
	    }
	 @GetMapping("/success")
	    public String showSuccessPage() {
	        // 成功画面の表示
	        return "redirect:/mypage";
	    }

	    @GetMapping("/mypage")
	    public String showMyPage() {
	        return "mypage"; // マイページのテンプレート名を返す
	    }

	}
