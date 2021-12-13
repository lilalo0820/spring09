package com.example.security.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.security.model.dao.UserDAO;

@Controller
public class UserController {

	@Inject
	BCryptPasswordEncoder pwdEncoder;
	
	@Inject
	UserDAO userDao;
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/user/login.do")
	public String login() {
		return "user/login";
	}
	
	@RequestMapping("/user/join.do")
	public String join() {
		return "user/join";
	}
	
	@RequestMapping("/user/denied")
	public String denied(Model model, HttpServletRequest request) {
		AccessDeniedException ex = (AccessDeniedException)request.getAttribute(WebAttributes.ACCESS_DENIED_403);
		model.addAttribute("message",ex);
		return "user/denied";
	}
	
	@RequestMapping("/admin/*")
	public String admin_main() {
		return "admin/main";
	}
	
	@RequestMapping("/user/insert.do")
	public String insert(String userid, String passwd, String name, String authority) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userid", userid);
		String pwd = pwdEncoder.encode(passwd);
		map.put("passwd", pwd);
		map.put("name", name);
		map.put("authority", authority);
		userDao.insert(map);
		return "user/login";
	}
	
	@RequestMapping("/user/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/"; 
	}
	
}
