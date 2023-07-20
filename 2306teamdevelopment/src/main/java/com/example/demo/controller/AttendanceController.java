package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.AttendanceRequest;
import com.example.demo.entity.AttendanceEntity;
import com.example.demo.service.AttendanceService;

@Controller
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @GetMapping("/attendance")
    public String showAttendance(Model model) {
        model.addAttribute("attendanceRequest", new AttendanceRequest());
        model.addAttribute("attendance", new AttendanceEntity()); 
        return "attendance";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute @Validated AttendanceRequest attendanceRequest, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getFieldErrors());
            return "attendance";
        }

        // フォームデータの受け取りと処理
        // attendanceRequestオブジェクトにはフォームの入力値が自動的にバインディングされます
        // フォームデータの保存や処理を行います

        return "redirect:/success";
    }

    @PostMapping("/attendance/submit")
    public String submitAttendanceForm(
        @ModelAttribute("attendance") @Validated AttendanceEntity attendance,
        BindingResult bindingResult,
        Model model,
        @RequestParam("userId") Integer userId) {

        attendance.setUserId(userId);

        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getFieldErrors());
            return "attendance";
        }

        // 出勤申請情報をデータベースに保存
        attendanceService.createAttendanceReport(attendance);
        return "redirect:/mypage";
    }

    @GetMapping("/success")
    public String showSuccessPage() {
        return "redirect:/mypage";
    }

    @GetMapping("/mypage")
    public String showMyPage() {
        return "mypage";
    }
}
