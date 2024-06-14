package com.jsp.hotelmanagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jsp.hotelmanagementSystem.dao.ItemDao;

@Controller
public class ItemController {
	
	@Autowired
	ItemDao itemDao;
}
