package com.nakihome.zerochallenge;

public class IndexController {
	@RequestMapping("/")
	public String index(HttpServletRequest req) {		
		return "redirect:/test/";
	}
}
