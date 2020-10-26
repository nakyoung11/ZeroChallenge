package com.nakihome.zerochallenge.user;

import org.apache.ibatis.annotations.Mapper;

import com.nakihome.zerochallenge.test.model.UserVO;

@Mapper
public interface UserMapper {
   int insUser(UserVO param);
   
   
   
   int selSnsLogin(String param);
	
}
