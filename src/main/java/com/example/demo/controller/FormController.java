package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {
	@Autowired
	CustomerRepo repo;
	
	
	@RequestMapping("/")
	public String details() {
		return "myForm";
	}
	
	@RequestMapping("/details")
	public String details(Customers customers) {
		repo.save(customers);
		return "myForm";
	}
	
	@RequestMapping("/getDetails")
	public String getDetails() {
		return "ViewCustomers";
	}
	
	
	  @PostMapping("/getDetails")
	  public ModelAndView viewDetails(@RequestParam("cId") int cId)
	  {
		  ModelAndView mv = new ModelAndView("Retrive");
		  Customers customers = repo.findById(cId).orElse(null);
		  mv.addObject(customers);
		  return mv;
	  }
	 
}
