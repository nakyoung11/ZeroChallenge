package com.nakihome.zerochallenge.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nakihome.zerochallenge.SecurityUtils;
import com.nakihome.zerochallenge.test.model.UserVO;

@Service
public class UserService {
	
	@Autowired
	private UserMapper mapper;
	
	
	public int join(UserVO param) {
		String pw= param.getUser_pw();
		String salt= SecurityUtils.generateSalt();
		String encrypt=SecurityUtils.getEncrypt(pw, salt);
		
		param.setUser_pw(encrypt);
		
		return mapper.insUser(param);
	}
}
