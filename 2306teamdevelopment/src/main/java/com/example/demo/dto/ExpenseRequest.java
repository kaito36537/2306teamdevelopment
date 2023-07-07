package com.example.demo.dto;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;


@Data
public class ExpenseRequest implements Serializable{
	
	
	private Integer user_id;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date shinsei_day;
	
	private String shinsei_koumoku;
	
	private String keihi_id;
	
	private String shinsei_money;
	
	private String bikou;

}


