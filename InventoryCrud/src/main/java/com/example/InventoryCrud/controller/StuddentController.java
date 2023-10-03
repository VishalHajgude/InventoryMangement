package com.example.InventoryCrud.controller;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import com.example.InventoryCrud.domain.Product;
import com.example.InventoryCrud.service.InventoryService;

@Controller
public class StuddentController {
	
	@Autowired
	private InventoryService service;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		List <Product> listproduct = service.listAll();
		model.addAttribute("listproduct",listproduct);
		System.out.println("Get  /");
		return "index";
		
	}
	
	@GetMapping("/new")
	public String add(Model model) {
		model.addAttribute("product", new Product());
		return "new";
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
   public String saveProduct(@ModelAttribute("produt") Product prd) {
	service.save(prd);
	return "index";
}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditStuedentPage(@PathVariable(name="id") int id) {
		ModelAndView mav = new ModelAndView("new");
		Product prd = service.get(id);
		mav.addObject("Product", prd);
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
		public String deletestudent (@PathVariable(name="id") int id) {
		service.delete(id);
		return "redirect:/";
		
		
	}
	



}
