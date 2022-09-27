package com.app.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class HomeController {
	public HomeController() {
		System.out.println("in ctor of "+getClass());
	}
	 @GetMapping("/")
	 public String showHomePage(Model map)
	 {
	
		 return "/admin/login";
	 }
	 @GetMapping("/index")//this is for testing only
	 public String showHomePageRedirect()
	 {
	
		 return "/index";
	 }
	 @GetMapping("/contact")//this is for testing only
	 public String contact()
	 {
		 System.out.println("contact page:");
	
		 return "/contact";
	 }
	 @GetMapping("/about")//this is for testing only
	 public String about()
	 {
		 System.out.println("about page:");
	
		 return "/about";
	 }
	 @GetMapping("/home")
	 public String home()
	 {
		 System.out.println("home page:");
	
		 return "/home";
	 }

}
