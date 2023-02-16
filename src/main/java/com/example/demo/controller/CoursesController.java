package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CoursesController {
	@RequestMapping("/courses")
	public String courses() {
		System.out.println("My courses");
		return "courses.jsp";
	}

}
