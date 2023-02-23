package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	 
	 @RequestMapping("/customers")
	 @ResponseBody
	 public List<Customers> getCustomers()
	 {
		 return repo.findAll();
	 }
	 
	 @RequestMapping("/customers/{cId}")
	 @ResponseBody
	 public Optional<Customers> getCustomersById(@PathVariable("cId") int cId)
	 {
		 return repo.findById(cId);
	 }
	 
	 @PostMapping("/addCustomers")
	 @ResponseBody
	 public Customers addCustomers(@RequestBody Customers customers)
	 {
		 repo.save(customers);
		 return customers;
	 }
	 
	 @DeleteMapping("/deleteCustomers/{cId}")
	 @ResponseBody
	 public Customers deleteCustomers(@PathVariable("cId") int cId)
	 {
		 Customers cust = repo.getOne(cId);
		 repo.delete(cust);
		 return cust;
	 }
	 
	 @PutMapping(path="/customers", consumes= {"application/json"})
	 @ResponseBody
	 public Customers updateCustomers(@RequestBody Customers customers)
	 {
		 repo.save(customers);
		 return customers;
	 }
}
