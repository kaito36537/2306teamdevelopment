package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.AttendanceEntity;
import com.example.demo.service.AttendanceListService;


@Controller
public class AttendanceListCotroller {
	
	@Autowired
	private AttendanceListService attendanceListService;
	
	@GetMapping(value="/attendanceList")
	public String displayList(Model model) {	
		List<AttendanceEntity>attendanceList = attendanceListService.serchAll();
		model.addAttribute("attendanceList", attendanceList);
		return "attendanceList";
	}
}
