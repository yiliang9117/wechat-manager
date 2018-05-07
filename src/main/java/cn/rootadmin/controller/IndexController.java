package cn.rootadmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("Main")
public class IndexController {
	
	
	@RequestMapping("/index")
	public String showMainPage() {
		return "/pages/index";
	}

}
