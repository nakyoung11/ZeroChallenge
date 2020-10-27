package com.nakihome.zerochallenge.user;

import org.apache.ibatis.annotations.Mapper;

import com.nakihome.zerochallenge.user.model.SnsUserVO;
import com.nakihome.zerochallenge.user.model.UserDMI;
import com.nakihome.zerochallenge.user.model.UserPARAM;
import com.nakihome.zerochallenge.user.model.UserVO;

@Mapper
public interface UserMapper {
   int insUser(UserVO param);
   int insSnsUser(SnsUserVO param);
   
   
   UserDMI selSnsUser(UserPARAM param);
   UserDMI selUSer(UserPARAM param);

}
