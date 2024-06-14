package com.jsp.hotelmanagementSystem.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.hotelmanagementSystem.dao.AdminDao;
import com.jsp.hotelmanagementSystem.entities.Admin;

@Controller
public class AdminController {
	
	
	@Autowired
	AdminDao dao;
	
	@RequestMapping("/addadmin")
	//handler use to create admin object and forward to AdminForm.jsp
	public ModelAndView addAdmin() {
		Admin admin=new Admin();
		ModelAndView mav=new ModelAndView();
		mav.addObject("adminobj",admin);
		mav.setViewName("AdminForm");
		return mav;
	}
	
	@RequestMapping("/saveadmin")
	//handler used to save admin details into database
	public ModelAndView saveAdmin(@ModelAttribute("adminobj") Admin admin ) {
		dao.saveAdmin(admin);
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("message","Admin registered successfully");
		mav.setViewName("Adminlogin");
		return mav;
	}
	
	@RequestMapping("/adminloginvalidate")
	//handler used to perform login validation for admin
	public ModelAndView loginValidation(ServletRequest request, HttpSession session) {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		Admin admin=dao.login(email, password);
		
		if(admin!=null) {
			session.setAttribute("admininfo",admin);
			ModelAndView mav=new ModelAndView();
			mav.addObject("message","loggedin successful");
			mav.setViewName("Adminoptions");
			return mav;	
		}
		
		else {
			ModelAndView mav=new ModelAndView();
			mav.addObject("message","Invalid Credentials");
			mav.setViewName("Adminlogin");
			return mav;
		}
	}
	
	@RequestMapping("/adminlogout")
	//handler is used to delete admin data in HttpSession
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		ModelAndView mav=new ModelAndView();
		mav.addObject("message","Loggedout Successfully");
		mav.setViewName("Adminhome");
		return mav;
	}
}
