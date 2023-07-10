package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "keihi_tb") 
public class ExpenseEntity {
	
	
	/*ユーザーID*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer user_id;
	
	/*申請日*/
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "shinsei_day")
	private Date shinsei_day;
	
	
	/*申請項目*/
	@Column(name = "shinsei_koumoku")
	private String shinsei_koumoku;
	
	/*申請ID*/
	@Column(name = "keihi_id")
	private Integer keihi_id;
	
	/*金額*/
	@Column(name = "shinsei_money")
	private Integer shinsei_money;
	
	/*備考*/
	@Column(name = "bikou")
	private String bikou;
	
}	
	
//		//	/*	ユーザーIDのセットとゲット
//		public Integer getUser_Id() {
//			return user_id;
//		}
//		public void setUser_Id(Integer user_Id) {
//			this.user_id = user_Id;
//		}
//		
//		//	申請日のセットとゲット
//		public Date getShinsei_Day() {
//			return shinsei_day;
//		}
//		public void setShinsei_Day(Date shinsei_Day) {
//			shinsei_day = shinsei_Day;
//		}
//		
//		//	申請項目のセットとゲット
//		public String getShinsei_Koumoku() {
//			return shinsei_koumoku;
//		}
//		public void setShinsei_Koumoku(Date date) {
//			shinsei_koumoku = date;
//		}
//		
//		//	申請IDのセットとゲット
//		public Integer getKeihi_Id() {
//			return keihi_id;
//		}
//		public void setKeihi_Id(Integer keihi_Id) {
//			this.keihi_id = keihi_Id;
//		}
//		
//		//	申請金額のセットとゲット
//		public Integer getShinsei_Money() {
//			return shinsei_money;
//		}
//		public void setShinsei_Money(Integer shinsei_Money) {
//			this.shinsei_money = shinsei_Money;
//		}
//		
//		//	備考のセットとゲット
//			public String getBikou() {
//				return bikou;
//			}
//			public void setBikou(String Bikou) {
//				this.bikou = Bikou;
//			}
//		
//		}
