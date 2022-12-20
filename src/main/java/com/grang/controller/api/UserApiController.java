package com.grang.controller.api;

import com.grang.dto.ResponseDto;
import com.grang.model.AuthType;
import com.grang.model.KakaoProfile;
import com.grang.model.User;
import com.grang.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;

@RestController
public class UserApiController {

	private UserServiceImpl userServiceImpl;
	
	private AuthenticationManager authenticationManager;
	
	@Autowired
	public UserApiController(UserServiceImpl userServiceImpl, AuthenticationManager authenticationManager) {
		this.userServiceImpl = userServiceImpl;
		this.authenticationManager = authenticationManager;
	}

	@PostMapping("/auth/api/user")
	public ResponseDto<Integer> join(@RequestBody User user) {
		userServiceImpl.회원가입(user);
		return new ResponseDto<>(HttpStatus.OK.value(), 1);
	}
	
	@GetMapping("/auth/api/kakao")
	public ModelAndView join(@RequestAttribute KakaoProfile kakaoProfile) {
		User kakaoUser = User.builder()
			.username(kakaoProfile.getProperties().nickname)
			.password(String.valueOf(Objects.hash(kakaoProfile.id)))
			.email(kakaoProfile.kakao_account.email)
			.auth(AuthType.KAKAO)
			.build();
		System.out.println("kakaoProfile = " + kakaoProfile);


		User orginUser = userServiceImpl.회원찾기(kakaoUser.getUsername());
		
		if(orginUser.getUsername() == null) {
			userServiceImpl.회원가입(kakaoUser);
		}

		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(kakaoProfile.getProperties().nickname, String.valueOf(Objects.hash(kakaoProfile.id))));
		SecurityContextHolder.getContext().setAuthentication(authentication);

		return new ModelAndView("redirect:/");
	}

	@GetMapping("/auth/api/findUser")
	public List<User> findUser(String username) {
		List<User> user = userServiceImpl.회원검색(username);
		return user;
	}

}
