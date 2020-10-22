package com.nakihome.zerochallenge.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nakihome.zerochallenge.Const;
import com.nakihome.zerochallenge.ViewRef;

@Controller
@RequestMapping("/user")
public class UserController {
	
	
	@RequestMapping(value="/login")
	public String login(Model model) {
		
	}
	
	@RequestMapping(value="/join")
	public String join(Model model) {
		
		model.addAttribute(Const.TITLE,"회원가입");
		model.addAttribute(Const.VIEW, "user/join");
		
		return ViewRef.TEMP_DEFAULT;
	}
	
	

}
