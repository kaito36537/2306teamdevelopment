package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Data
@Table(name = "keihi_tb")
public class ExpenseEntity{

	/*ユーザーID*/
	@Column(name = "user_id")
	@NotNull(message = "ユーザーIDを入力してください")
	private Integer userId;

	/*申請日*/
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "shinsei_day")
	@NotNull(message = "申請日は必須です")
	private Date shinseiDay;

	/*申請項目*/
	@Column(name = "shinsei_koumoku")
	@NotNull(message = "申請項目は必須です")
	private String shinseiKoumoku;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer keihiId;

	/*金額*/
	@Column(name = "shinsei_money")
	@NotNull(message = "申請金額は必須です")
	private Integer shinseiMoney;

	/*備考*/
	@Column(name = "remarks")
	@Size(min = 0, max = 500)
	private String remarks;

}
