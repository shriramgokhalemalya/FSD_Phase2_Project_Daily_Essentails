package com.shriramgokhale.projectdemo.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shriramgokhale.projectdemo.dao.AppSalesDAO;
import com.shriramgokhale.projectdemo.model.Sales;
import com.shriramgokhale.projectdemo.utils.WebUtils;

@Controller
public class SalesController {
	
	@Autowired
	AppSalesDAO appSalesDAO;
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable(name="id")int id) {
		appSalesDAO.deleteSale(id);
		return "redirect:/admin";
	}
	
	@RequestMapping("/addSales")
	public String addSales(@RequestParam("item") String item, @RequestParam("quantity") String quantity,@RequestParam("quantity") float price,Model model) {
		
		appSalesDAO.addSale(item,quantity,price);
		return "redirect:/admin";
	}
	
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable(name="id")int id,Model model,Principal principal) {
		
		Sales sale = appSalesDAO.getSales(id);
		model.addAttribute("salesEdit", sale);
		return "editSalesPage";
	}
	
	@RequestMapping("/editSales")
	public String editSales(@RequestParam("id")int id,@RequestParam("item") String item, @RequestParam("quantity") String quantity,@RequestParam("quantity") float price,Model model) {
		
		appSalesDAO.editSale(id,item,quantity,price);
		return "redirect:/admin";
	}
	
}
