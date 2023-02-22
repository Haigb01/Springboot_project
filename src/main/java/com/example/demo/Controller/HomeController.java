package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/home")
	public String home() {
		return "admin/categories/content1";
	}
	
	@RequestMapping("/admin/categories/search")
	public String search() {
		return "admin/categories/search";
	}
}
