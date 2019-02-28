package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.GlobalResponse;
import com.model.Laptop;
import com.service.LaptopService;

@Controller
public class LaptopController {
	@Autowired
	private LaptopService LService;

	
	@RequestMapping(value = "rest/getLaptops", method = RequestMethod.GET)
	public @ResponseBody
	GlobalResponse gl() {
		System.out.println("calling get Laptops method");
		return LService.getAllLaptops();
	}

	@RequestMapping(value = "rest/getLBrands", method = RequestMethod.GET)
	public @ResponseBody
	GlobalResponse glb() {
		System.out.println("calling get Laptops Brands method");
		return LService.getLBrands();
	}
	
	@RequestMapping(value = "rest/getLColor", method = RequestMethod.GET)
	public @ResponseBody
	GlobalResponse glc() {
		System.out.println("calling get Laptops Color method");
		return LService.getLColor();
	}
	
	@RequestMapping(value = "rest/getLOpsys", method = RequestMethod.GET)
	public @ResponseBody
	GlobalResponse glo() {
		System.out.println("calling get Laptops Opsys method");
		return LService.getLOpsys();
	}
	
	@RequestMapping(value = "rest/getStockedLaptops", method = RequestMethod.GET)
	public @ResponseBody GlobalResponse gsl() {
		System.out.println("calling getLaptopsInStock method");
		return LService.getLaptopInStock();
	}

	@RequestMapping(value = "rest/sortLaptops", method = RequestMethod.POST)
	public @ResponseBody
	GlobalResponse gsortl(@RequestBody List<Laptop> myData) {
		System.out.println("calling sortLaptops method");
		return LService.sortAsc(myData);
	}

	@RequestMapping(value = "rest/sortDescLp", method = RequestMethod.POST)
	public @ResponseBody
	GlobalResponse gdescl(@RequestBody List<Laptop> myData) {
		System.out.println("calling sortDescAccessories method");
		return LService.sortAsc(myData);
	}

	@RequestMapping(value = "rest/insertLaptops", method = RequestMethod.POST)
	public @ResponseBody
	GlobalResponse inserta(@RequestBody Laptop myData) {
		System.out.println("calling insertAccessories method");
		return LService.insertLaptop(myData);
	}
}
