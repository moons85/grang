package com.grang.service;

import com.grang.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

	void 회원가입(User user);

	void 회원수정();

	User 회원찾기(String username);

	List<User> 회원검색(String username);

}
