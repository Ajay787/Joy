package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.model.User;
import com.app.service.UserService;

@Controller
@RequestMapping(value="/admin/**")
public class AdminController {
	@Autowired
	private UserService userService;
	
	
	
	@RequestMapping(value="index.html", method=RequestMethod.GET)
	public String uixHome(ModelMap modelMap) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelMap.addAttribute("userName","Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
		return "admin/index";
	}
	
	@RequestMapping(value="about.html", method=RequestMethod.GET)
	public String about() {
		return "admin/about";
	}
	@RequestMapping(value="teachers.html", method=RequestMethod.GET)
	public String teacher() {
		return "admin/teachers";
	}
	
	@RequestMapping(value="contact.html", method=RequestMethod.GET)
	public String contact() {
		return "admin/contact";
	}
	@RequestMapping(value="elements.html", method=RequestMethod.GET)
	public String elements() {
		return "admin/elements";
	}
	@RequestMapping(value="news.html", method=RequestMethod.GET)
	public String news() {
		return "admin/news";
	}
	@RequestMapping(value="offers.html", method=RequestMethod.GET)
	public String offers() {
		return "admin/offers";
	}
	
}
