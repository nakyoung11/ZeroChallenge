package com.nakihome.zerochallenge.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@RequestMapping(value = "/questionReg")
	public String questionReg() {
		return "test/questionReg";
			
	}
	
	
}
