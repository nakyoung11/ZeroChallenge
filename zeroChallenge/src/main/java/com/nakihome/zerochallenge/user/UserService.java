package com.nakihome.zerochallenge.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nakihome.zerochallenge.Const;
import com.nakihome.zerochallenge.SecurityUtils;
import com.nakihome.zerochallenge.user.model.SnsUserVO;
import com.nakihome.zerochallenge.user.model.UserDMI;
import com.nakihome.zerochallenge.user.model.UserPARAM;

@Service
public class UserService {

	@Autowired
	private UserMapper mapper;

	public int join(SnsUserVO param) {

		if (param.getSubscription_path() == 3) {
			System.out.println("DB추가");
			System.out.println("가입경로"+param.getSubscription_path());

			String pw = param.getUser_pw();
			String salt = SecurityUtils.generateSalt();
			String encrypt = SecurityUtils.getEncrypt(pw, salt);
			
			param.setSalt(salt);
			param.setUser_pw(encrypt);
			
			return mapper.insUser(param);
		} else {
			
			String id = param.getUser_id();
			String salt = SecurityUtils.generateSalt();
			String encrypt = SecurityUtils.getEncrypt(id, salt);
			
			param.setSalt(salt);
			param.setUser_id(encrypt);
			return mapper.insSnsUser(param);
		}

	}

	public int login(UserPARAM param) {
		System.out.println("login: "+ param.getUser_id());
		if(param.getUser_id()==null) {	return Const.NO_ID;	}
		UserDMI dbUser= mapper.selSnsUser(param);
		
		if(dbUser==null) {return 5;}
		
		String cryptId=SecurityUtils.getEncrypt(param.getUser_id(), dbUser.getSalt());
		System.out.println("userid"+cryptId);
		if(!cryptId.equals(dbUser.getUser_id())) {
			return Const.NO_PW;
		}
		param.setUser_id(null);
		param.setI_user(dbUser.getI_user());
		param.setUser_nm(dbUser.getUser_nm());
			
		return Const.SUCCESS;
		
	}
}
