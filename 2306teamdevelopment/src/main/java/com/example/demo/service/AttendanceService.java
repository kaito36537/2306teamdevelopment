package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AttendanceEntity;
import com.example.demo.repository.AttendanceRepository;

@Service
public class AttendanceService {

	@Autowired
	private AttendanceRepository attendanceRepository;




		public void createAttendanceReport(AttendanceEntity attendance) {
			AttendanceEntity attendanceEntity = new AttendanceEntity();
			attendanceEntity.setUserId(attendance.getUserId());
			attendanceEntity.setStatus(attendance.getStatus());
			attendanceEntity.setAttendanceDate(attendance.getAttendanceDate());
			attendanceEntity.setAttendanceTime(attendance.getAttendanceTime());
			attendanceEntity.setRemarks(attendance.getRemarks());
			attendanceRepository.save(attendanceEntity);
		}
	

	}// データベースへのクエリの実行などを行う
