package com.example.demo.entity;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;	

@Entity
@Table(name = "attendance") 
public class AttendanceEntity {
	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId")
	private Long userId;
	/**
	 * 出勤日
	 */
	@Column(name = "attendance_Date")
	private Date attendanceDate;
	/**
	 * 出勤時間
	 */
	@Column(name = "attendance_Time")
	private Time attendanceTime;
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
	        return attendanceDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	    }

	    public void setAttendanceDate(LocalDate attendanceDate) {
	        this.attendanceDate = Date.from(attendanceDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	    }

	    public LocalTime getAttendanceTime() {
	        return attendanceTime.toLocalTime();
	    }

	    public void setAttendanceTime(LocalTime attendanceTime) {
	        this.attendanceTime = Time.valueOf(attendanceTime);
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

