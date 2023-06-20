package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;	

@Entity
@Table(name = "expense") 
public class ExpenseEntity {
	
	/*ユーザーID*/
	@Id
	@Column(name = "user_id")
	private String user_id;
	
	/*申請日*/
	@Column(name = "shinsei_day")
	private Date shinsei_day;	
	
	/*申請項目*/
	@Column(name = "shinsei_koumoku")
	private String shinsei_koumoku;		
	
	/*申請ID*/
	@Column(name = "keihi_id")
	private String keihi_id;
	
	/*金額*/
	@Column(name = "shinsei_money")
	private String shinsei_money;
	
	/*備考*/
	@Column(name = "bikou")
	private String bikou;
}