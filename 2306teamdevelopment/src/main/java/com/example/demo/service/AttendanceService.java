package com.example.demo.service;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.AttendanceRequest;
import com.example.demo.entity.AttendanceEntity;
import com.example.demo.repository.AttendanceRepository;

@Service
public class AttendanceService {

	@Autowired
	private AttendanceRepository attendanceRepository;

	@Transactional
	public void createAttendanceReport(Long userId, String status, LocalDate attendanceDate, LocalTime attendanceTime, String remarks) {
		AttendanceEntity attendance = new AttendanceEntity();
		attendance.setUserId(userId);
		attendance.setStatus(status);
		attendance.setAttendanceDate(attendanceDate);
		attendance.setAttendanceTime(attendanceTime);
		attendance.setRemarks(remarks);

		attendanceRepository.save(attendance);
	}


	@Transactional
	public void createAttendanceReport(AttendanceRequest attendanceRequest) {
		Long userId = attendanceRequest.getUserId();
		String status = attendanceRequest.getStatus();
		LocalDate attendanceDate = attendanceRequest.getAttendanceDate();
		LocalTime attendanceTime = attendanceRequest.getAttendanceTime();
		String remarks = attendanceRequest.getRemarks();

		createAttendanceReport(userId, status, attendanceDate, attendanceTime, remarks);

	}

}
