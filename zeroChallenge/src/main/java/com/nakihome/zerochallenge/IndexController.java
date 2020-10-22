package com.nakihome.zerochallenge;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;

public class IndexController {
	@RequestMapping("/")
	public String index(HttpServletRequest request) {		
		return "redirect:/main";
	}
}
