package com.example.demo.dto;


import java.util.Date;

import lombok.Data;



@Data
public class ExpenseRequest{
	
	
	private Integer user_id;
	
	private Date shinsei_day;
	
	private String shinsei_koumoku;
	
	private String keihi_id;
	
	private String shinsei_money;
	
	private String bikou;






}


