package com.jsp.hotelmanagementSystem.controller;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.hotelmanagementSystem.dao.HotelDao;
import com.jsp.hotelmanagementSystem.entities.Hotel;

@Controller
public class HotelController {
	@Autowired
	HotelDao dao;
	
	@RequestMapping("/addhotel")
	//handler used to create hotel class object and pass it to HotelForm.jsp
	public ModelAndView addHotel() {
		Hotel hotel=new Hotel();
		ModelAndView mav=new ModelAndView();
		mav.addObject("hotelobj",hotel);
		mav.setViewName("HotelForm");
		return mav;
	}
	
	@RequestMapping("/savehotel")
	//handler used to save hotel information in database
	public ModelAndView saveHotel(@ModelAttribute("hotelobj") Hotel hotel) {
		hotel.setStatus("Not approved");
		dao.saveHotel(hotel);
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("message","Your account is in review, please wait for some time");
		mav.setViewName("HotelLogin");
		return mav;
	}
	
	@RequestMapping("/hotelloginvalidation")
		//handler used to perform login validation for hotel and return appropriate response
		public ModelAndView hotelLoginValidation(ServletRequest request,HttpSession session) {
		   String email = request.getParameter("email");
		   String password = request.getParameter("password");

			Hotel hotel = dao.login(email, password);

			if (hotel != null) {
				if(hotel.getStatus().equals("Not approved")) {
				ModelAndView mav = new ModelAndView();
				mav.addObject("message", "Your account is in review ,please wait for sometime");
				mav.setViewName("displaymessage");
				return mav;
				}
			 
				else if (hotel.getStatus().equals("blocked")){
				ModelAndView mav = new ModelAndView();
				mav.addObject("message", "Your Account is Blocked");
				mav.setViewName("displaymessage");
				return mav;
				}
				else {
				//storing hotel entity object into session
				//storing the logged in hotel into session
				session.setAttribute("hotelinfo", hotel.getId());
				ModelAndView mav = new ModelAndView();
				mav.addObject("message", "Loggedin Successfully");
				mav.setViewName("Hoteloptions");
				return mav;
				}
			}
			else {
				ModelAndView mav=new ModelAndView();
				mav.addObject("message", "Invalid Credentials");
				mav.setViewName("HotelLogin");
				return mav;
			}
		}
			
			
			@RequestMapping("/fetchunapprovedhotels")
			//handler used to find unapproved hotels
			public ModelAndView fetchUnapprovedHotels() {
				List<Hotel> hotels=dao.findUnapprovedhotels();
				ModelAndView mav=new ModelAndView();
				mav.addObject("unapprovedhotels",hotels);
				mav.setViewName("displayunapprovedhotels");
				return mav;
			}
			
			@RequestMapping("/approvehotel")
			//handler is used to modify the hotel status as approved
			public ModelAndView approveHotel(@RequestParam("id") int id) {
				Hotel h=dao.findHotelById(id);
				h.setStatus("approved");
				dao.updateHotel(h);
				
				ModelAndView mav=new ModelAndView();
				mav.setViewName("redirect:/fetchunapprovedhotels");
				return mav;
			}
			
			@RequestMapping("/hotellogout")
			//handler is used to delete hotel data in HttpSession
			public ModelAndView logout(HttpSession session) {
				session.invalidate();
				ModelAndView mav=new ModelAndView();
				mav.addObject("message","Loggedout Successfully");
				mav.setViewName("HotelHomepage");
				return mav;
			}
}
