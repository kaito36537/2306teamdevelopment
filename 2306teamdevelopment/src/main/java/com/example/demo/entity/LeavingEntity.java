package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Data
@Table(name = "attendance") 
public class LeavingEntity {
	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	@NotNull(message = "IDは必須です")
	private Long userId;
	/**
	 * 退勤日
	 */
	@Column(name = "leaving_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "退勤日は必須です") // 適切な日付フォーマットを指定
	private LocalDate leavingDate;
	/**
	 * 退勤時間
	 */
	@Column(name = "leaving_time")
	@NotNull(message = "退勤時間は必須です") 
	private LocalTime leavingTime;
	/**
	 * ステータス
	 */
	@Column(name = "status")
	@NotNull(message = "ステータスは必須です") // 必須フィールドのバリデーション
	private String status;
	/**
	 * 備考
	 */
	@Column(name = "remarks")
	private String remarks;
	/**
	 * 休憩時間
	 */
	@Column(name = "break_time")
	@NotNull(message = "休憩時間は必須です")
	private LocalTime breakTime;
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public LocalDate getLeavingDate() {
		return leavingDate;
	}
	public void setLeavingDate(LocalDate leavingDate) {
	    this.leavingDate = leavingDate;
	}

	public LocalTime getLeavingTime() {
	    return leavingTime;
	}

	public void setLeavingTime(LocalTime leavingTime) {
	    this.leavingTime = leavingTime;
	    }

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public LocalTime getBreakTime() {
		return breakTime;
	}

	public void setBreakTime(LocalTime breaktime) {
		this.breakTime = breaktime;
	}
	
	
	
}
