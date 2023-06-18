package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.UserRequest;
import com.example.demo.dto.UserUpdateRequest;
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
	public void create(UserRequest userRequest) {
		
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
	
		/*
		 * ユーザー情報　主キー検索
		 * @return 検索結果
		 */
		public UserEntity findById(Integer user_id) {
			return userRepository.findById(user_id).get();
		}
		
		/*
		 *ユーザー情報更新 
		 */
		public void update(UserUpdateRequest userUpdateRequest) {
			UserEntity user = findById(userUpdateRequest.getUser_id());
			user.setName(userUpdateRequest.getName());
			user.setFurigana(userUpdateRequest.getFurigana());
			user.setMail(userUpdateRequest.getMail());
			user.setPassword(userUpdateRequest.getPassword());
			userRepository.save(user);
		}
}
