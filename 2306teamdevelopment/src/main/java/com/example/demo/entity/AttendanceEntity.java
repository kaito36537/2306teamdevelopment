package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;	

@Entity
@Table(name = "attendance") 
public class AttendanceEntity {
	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;
	/**
	 * 出勤日
	 */
	@Column(name = "attendance_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd") // 適切な日付フォーマットを指定
	private LocalDate attendanceDate;
	/**
	 * 出勤時間
	 */
	@Column(name = "attendance_time")
	private LocalTime attendanceTime;
	/**
	 * ステータス
	 */
	@Column(name = "status")
	private String status;
	/**
	 * 備考
	 */
	@Column(name = "remarks")
	private String remarks;
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public LocalDate getAttendanceDate() {
		return attendanceDate;
	}
	public void setAttendanceDate(LocalDate attendanceDate) {
	    this.attendanceDate = attendanceDate;
	}

	public LocalTime getAttendanceTime() {
	    return attendanceTime;
	}

	public void setAttendanceTime(LocalTime attendanceTime) {
	    this.attendanceTime = attendanceTime;
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
}
