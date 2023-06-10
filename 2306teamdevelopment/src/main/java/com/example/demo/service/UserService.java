package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.UserRequest;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {
	
	/*
	 * Repository
	 */
	@Autowired
	private UserRepository userRepository;
	
	/*
	 * ユーザーを新規登録
	 */
	private void register(UserRequest userRequest) {
		
		/*
		 * ユーザー新規登録
		 */
		UserEntity user = new UserEntity();
		user.setName(userRequest.getName());
		user.setFurigana(userRequest.getFurigana());
		user.setMail(userRequest.getMail());
		user.setPassword(userRequest.getPassword());
		userRepository.save(user);
		
	}
}
