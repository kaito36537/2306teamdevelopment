package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "keihi_tb") 
public class ExpenseEntity {
	
	
	/*ユーザーID*/
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long user_id;
	
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
	
	
	
	
/*ユーザーIDのセットとゲット*/
public Long getUserId() {
	return user_id;
}
public void setUserId(Long userId) {
	this.user_id = userId;
}

/*申請日のセットとゲット*/
public Date getShinsei_Day() {
	return shinsei_day;
}
public void setShinsei_Day(Date shinsei_Day) {
	this.shinsei_day = shinsei_Day;
}

/*申請項目のセットとゲット*/
public String getShinsei_Koumoku() {
	return shinsei_koumoku;
}
public void setShinsei_Koumoku(String shinsei_Koumoku) {
	this.shinsei_koumoku = shinsei_Koumoku;
}

/*申請IDのセットとゲット*/
public String getKeihi_Id() {
	return keihi_id;
}
public void setKeihi_Id(String keihi_Id) {
	this.keihi_id = keihi_Id;
}

/*申請金額のセットとゲット*/
public String getShinsei_Money() {
	return shinsei_money;
}
public void setShinsei_Money(String shinsei_Money) {
	this.shinsei_money = shinsei_Money;
}

/*備考のセットとゲット*/
public String getBikou() {
	return bikou;
}
public void setBikou(String Bikou) {
	this.bikou = Bikou;
}

}
