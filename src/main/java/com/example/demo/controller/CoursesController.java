package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class CoursesController {
	@RequestMapping("/courses")
	/*public String courses(HttpServletRequest req) {
		HttpSession session = req.getSession();
		String cName = req.getParameter("cName");
		System.out.println("My courses: " + cName);
		session.setAttribute("cName", cName);
		return "courses";
	}*/
	
	/*public String courses(@RequestParam("cName") String courseName, HttpSession session) {
		session.setAttribute("cName", courseName);
		return "courses";
	}*/
	
	public ModelAndView courses(@RequestParam("cName") String courseName, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("cName", courseName);
		mv.setViewName("courses");
		return mv;
	}


}
