package com.nakihome.zerochallenge.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nakihome.zerochallenge.Const;
import com.nakihome.zerochallenge.ViewRef;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@RequestMapping(value = "/questionReg")
	public String questionReg(Model model) {
		model.addAttribute(Const.TITLE, "ZERO");
		model.addAttribute(Const.VIEW, "test/questionReg");
		
		return ViewRef.TEMP_MAIN;
			
	}
	
	
}
