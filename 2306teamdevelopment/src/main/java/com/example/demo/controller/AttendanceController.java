package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.AttendanceRequest;
import com.example.demo.service.AttendanceService;

@Controller
@RequestMapping("/attendance")
public class AttendanceController {


	@Autowired
	private AttendanceService attendanceService;

	

	@GetMapping("/attendance")
	public String showAttendance(Model model) {
		model.addAttribute("attendanceRequest", new AttendanceRequest());
		return "attendance"; // 出勤報告入力画面のテンプレート名を返す
	}

	@PostMapping("/attendance/submit")
	public String submitAttendanceForm(@ModelAttribute("attendanceRequest") AttendanceRequest attendanceRequest, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			// 入力エラーがある場合、再度入力画面を表示
			return "attendance";
		}
		// 出勤申請情報をデータベースに保存
		attendanceService.createAttendanceReport(attendanceRequest);

		return "redirect:/attendance/list"; // 勤怠一覧画面にリダイレクト
	}

	@GetMapping("/success")
	public String successPage() {
		// 成功画面の表示
		return "redirect:/mypage";
	}

	@GetMapping("/backToMyPage")
	public String backToMyPage() {
		// 戻るボタンが押された場合の処理
		return "redirect:/mypage"; // マイページにリダイレクト
	}
}