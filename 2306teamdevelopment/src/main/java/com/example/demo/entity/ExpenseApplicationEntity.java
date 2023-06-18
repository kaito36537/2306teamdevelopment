[com.example.demo.entity.ExpenseApplicationEntity.java]

package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
* ユーザー情報 Entity
*/
@ここ追加
@ここ追加
@Table(//追加)
public class UserEntity {

/**
* ID
*/
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
//2行追加

/**
* 名前
*/
@Column(name = "name")
private String name;

/**
* 住所
*/
@Column(name = "address")
private String address;

/**
* 電話番号
*/
//2行追加

/**
* 更新日時
*/
//2行追加

/**
* 登録日時
*/
@Column(name = "create_date")
private Date createDate;

}