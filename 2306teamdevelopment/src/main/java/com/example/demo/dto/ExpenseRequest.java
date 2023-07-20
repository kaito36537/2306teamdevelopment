package com.example.demo.dto;



import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ExpenseRequest {

	private Integer user_id;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date shinsei_day;

	private String shinsei_koumoku;

	private Integer shinsei_money;

	private String remarks;

}
