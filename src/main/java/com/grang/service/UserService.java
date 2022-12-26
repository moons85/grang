package com.grang.service;

import com.grang.model.AuthType;
import com.grang.model.RoleType;
import com.grang.model.User;
import com.grang.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

	private UserRepository userRepository;
	
	private BCryptPasswordEncoder encoder;
	
	
	@Autowired
	public UserService(UserRepository userRepository, BCryptPasswordEncoder encoder) {
		this.userRepository = userRepository;
		this.encoder = encoder;
	}

	@Transactional
	public void 회원가입(User user) {
		String rawPassword = user.getPassword();
		String encPassword = encoder.encode(rawPassword);
		user.setPassword(encPassword);
		user.setProfileImage("/image/normal.jpg");
		user.setAuth(AuthType.GENERAL);
		user.setRoleType(RoleType.USER);
		userRepository.save(user);
	}

	@Transactional(readOnly = true)
	public User 회원찾기(String username) {
		return userRepository.findByUsername(username)
				.orElse(new User());
	}

	@Transactional(readOnly = true)
	public User 회원찾기ById(int id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("아이디 존재 x"));
	}

	@Transactional(readOnly = true)
	public List<User> 회원검색(String username) {
		return userRepository.findByUsername2(username);
	}

}
