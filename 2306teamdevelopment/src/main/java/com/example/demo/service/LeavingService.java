package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.LeavingEntity;
import com.example.demo.repository.LeavingRepository;

@Service
public class LeavingService {
	
	@Autowired
	private LeavingRepository leavingRepository;
	
	public void createLeavingReport(LeavingEntity leaving) {
		LeavingEntity leavingEntity = new LeavingEntity();
		leavingEntity.setUserId(leaving.getUserId());
		leavingEntity.setStatus(leaving.getStatus());
		leavingEntity.setLeavingDate(leaving.getLeavingDate());
		leavingEntity.setLeavingTime(leaving.getLeavingTime());
		leavingEntity.setRemarks(leaving.getRemarks());
		leavingEntity.setBreakTime(leaving.getBreakTime());

		leavingRepository.save(leavingEntity);
	}// データベースへのクエリの実行などを行う


}
