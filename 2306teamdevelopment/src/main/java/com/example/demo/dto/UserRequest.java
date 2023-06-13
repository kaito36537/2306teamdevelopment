package com.example.demo.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class UserRequest implements Serializable{

	/*
	 * name
	 */
	@NotEmpty(message = "名前を入力してください。")
	@Size(max = 20, message = "名前は20文字以内で入力してください。")
	private String name;
	
	/*
	 * furigana
	 */
	@NotEmpty(message = "フリガナを入力してください。")
	@Size(max = 20, message = "フリガナは20文字以内で入力してください。")
	@Pattern(regexp = "^[\\u30A0-\\u30FF]+$")
	private String furigana;
	

	/*
	 * mail
	 */
	@Email
	@NotEmpty(message = "メールアドレスを入力してください。")
	@Size(max = 20, message = "メールアドレスは20文字以内で入力してください。")
	private String mail;
	
	/*
	 * password 
	 */
	
	@NotEmpty(message = "パスワードを入力してください。")
	private String password;
}
