package com.nakihome.zerochallenge.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nakihome.zerochallenge.Const;
import com.nakihome.zerochallenge.ViewRef;
import com.nakihome.zerochallenge.test.model.UserVO;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	/*GET*/
	
	@RequestMapping(value="/login")
	public String login(Model model) {
		model.addAttribute(Const.TITLE,"로그인");
		model.addAttribute(Const.VIEW, "user/login");
		
		return ViewRef.TEMP_DEFAULT;
	}
	
	@RequestMapping(value="/join")
	public String join(Model model) {
		
		model.addAttribute(Const.TITLE,"회원가입");
		model.addAttribute(Const.VIEW, "user/join");
		
		return ViewRef.TEMP_DEFAULT;
	}
	
	
	/*POST*/
	
	@RequestMapping(value="/join", method = RequestMethod.POST)
	public String join(UserVO param) {
		int result = service.join(param);
		
		return "";
	}
	

}
