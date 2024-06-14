package com.jsp.hotelmanagementSystem.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.hotelmanagementSystem.dao.CustomerDao;
import com.jsp.hotelmanagementSystem.entities.Admin;
import com.jsp.hotelmanagementSystem.entities.Customer;

@Controller
public class CustomerController {
	@Autowired
	CustomerDao customerDao;
	
	@RequestMapping("/addcustomer")
	//handler used to create customer class object and pass it to CustomerForm.jsp
	public ModelAndView addCustomer(){
		Customer customer=new Customer();
		ModelAndView mav=new ModelAndView();
		mav.addObject("customerobj",customer);
		mav.setViewName("CustomerForm");
		return mav;
	}
	
	@RequestMapping("/savecustomer")
	public ModelAndView saveCustomer(@ModelAttribute("customerobj") Customer customer) {
		customerDao.saveCustomer(customer);
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("message","Customer registered successfully");
		mav.setViewName("CustomerLogin");
		return mav;
	}
	
	@RequestMapping("/loginvalidation")
	public ModelAndView loginValidation(ServletRequest request, HttpSession session) {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		Customer customer=customerDao.login(email, password);
		
		if(customer!=null) {
			session.setAttribute("customerinfo",customer);
			ModelAndView mav=new ModelAndView();
			mav.addObject("message","Loggedin Successful");
			mav.setViewName("CustomerOptions");
			return mav;	
		}
		
		else {
			ModelAndView mav=new ModelAndView();
			mav.addObject("message","Invalid Credentials");
			mav.setViewName("CustomerLogin");
			return mav;
		}
	} 
}
