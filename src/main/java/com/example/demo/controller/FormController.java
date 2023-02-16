package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {

	@GetMapping("/form")
	public String form() {
		return "myForm";
	}
	
	@PostMapping("/details")
		public String viewDetails(@RequestParam("cId") String cId, @RequestParam("cName") String cName, @RequestParam("cEmail") String cEmail, ModelMap modelMap) {
			modelMap.put("cId", cId);
			modelMap.put("cName", cName);
			modelMap.put("cEmail", cEmail);
			return "ViewCustomers";
		}
	
}
