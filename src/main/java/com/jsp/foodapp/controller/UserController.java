package com.jsp.foodapp.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.foodapp.dao.UserDao;
import com.jsp.foodapp.entities.User;

@Controller
public class UserController {
	@Autowired
	UserDao dao;

	@RequestMapping("/adduser")
	public ModelAndView addUser() {
		ModelAndView mav = new ModelAndView("createuser");
		User u = new User();
		mav.addObject("user", u);
		return mav;
	}

	@RequestMapping("/saveuser")
	public ModelAndView saveUser(@ModelAttribute("user") User u) {
		dao.saveUser(u);
		ModelAndView mav = new ModelAndView("loginuser");
		return mav;
	}

	@RequestMapping("/validateuser")
	public ModelAndView loginUser(ServletRequest req, HttpSession session) {
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		User u = dao.login(email, password);
		if(u!=null) {
			ModelAndView mav = new ModelAndView("useroptions") ;
			session.setAttribute("user", u) ;
			return mav ;
		}
		else {
			ModelAndView mav = new ModelAndView("loginuser") ;
			mav.addObject("message", "invalid credentials") ;
			return  mav ;
		}
	}
}
