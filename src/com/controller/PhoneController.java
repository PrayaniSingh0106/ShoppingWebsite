package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.GlobalResponse;
import com.model.Phone;
import com.service.PhoneService;

@Controller
public class PhoneController {
	@Autowired
	private PhoneService LService;

	
	@RequestMapping(value = "rest/getPhones", method = RequestMethod.GET)
	public @ResponseBody
	GlobalResponse gp() {
		System.out.println("calling get Phones method");
		return LService.getAllPhones();
	}

	@RequestMapping(value = "rest/getPhBrands", method = RequestMethod.GET)
	public @ResponseBody
	GlobalResponse gpb() {
		System.out.println("calling get Phone Brands method");
		return LService.getPhBrands();
	}
	
	@RequestMapping(value = "rest/getPhOps", method = RequestMethod.GET)
	public @ResponseBody
	GlobalResponse gpo() {
		System.out.println("calling get Phone Operating method");
		return LService.getPhOps();
	}
	
	@RequestMapping(value = "rest/getPhColors", method = RequestMethod.GET)
	public @ResponseBody
	GlobalResponse gpc() {
		System.out.println("calling get Phone Colors method");
		return LService.getPhColors();
	}
	
	@RequestMapping(value = "rest/getStockedPhones", method = RequestMethod.GET)
	public @ResponseBody GlobalResponse gsp() {
		System.out.println("calling getPhonesInStock method");
		return LService.getPhoneInStock();
	}

	@RequestMapping(value = "rest/sortPhones", method = RequestMethod.POST)
	public @ResponseBody
	GlobalResponse gsortp(@RequestBody List<Phone> myData) {
		System.out.println("calling sortPhones method");
		return LService.sortAsc(myData);
	}

	@RequestMapping(value = "rest/sortDescPh", method = RequestMethod.POST)
	public @ResponseBody
	GlobalResponse gdescp(@RequestBody List<Phone> myData) {
		System.out.println("calling sortDescPhones method");
		return LService.sortAsc(myData);
	}

	@RequestMapping(value = "rest/insertPhones", method = RequestMethod.POST)
	public @ResponseBody
	GlobalResponse insertp(@RequestBody Phone myData) {
		System.out.println("calling insertPhones method");
		return LService.insertPhone(myData);
	}

}
