package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.Accessory;
import com.model.GlobalRequest;
import com.model.GlobalResponse;
import com.service.AccessoryService;

@Controller
public class AccessoryController {

	@Autowired
	private AccessoryService AService;

	@RequestMapping(value = "rest/getAccessories", method = RequestMethod.GET)
	public @ResponseBody
	GlobalResponse ga() {
		System.out.println("calling get Accessories method");
		return AService.getAllAccessories();
	}
	
	@RequestMapping(value = "rest/getAcBrands", method = RequestMethod.GET)
	public @ResponseBody
	GlobalResponse gab() {
		System.out.println("calling get Accessories Brands method");
		return AService.getAcBrands();
	}
	
	@RequestMapping(value = "rest/getAcTypes", method = RequestMethod.GET)
	public @ResponseBody
	GlobalResponse gat() {
		System.out.println("calling get Accessory Types method");
		return AService.getAcTypes();
	}

	@RequestMapping(value = "rest/getTypeAccessories", method = RequestMethod.POST)
	public @ResponseBody
	GlobalResponse gta(@RequestBody GlobalRequest myData) {
		System.out.println("calling getAccessoriesByType method");
		return AService.getAccessoriesOfType(myData.getReqData());
	}

	@RequestMapping(value = "rest/getStockedAccessories", method = RequestMethod.GET)
	public @ResponseBody
	GlobalResponse gsa() {
		System.out.println("calling getAccessoriesInStock method");
		return AService.getAccessoriesInStock();
	}

	@RequestMapping(value = "rest/getStockedAcType", method = RequestMethod.POST)
	public @ResponseBody
	GlobalResponse gsta(@RequestBody GlobalRequest myData) {
		System.out.println("calling getAccessoriesInStockOfType method");
		return AService.getAccessoriesInStock(myData.getReqData());
	}

	@RequestMapping(value = "rest/sortAccessories", method = RequestMethod.POST)
	public @ResponseBody
	GlobalResponse gsorta(@RequestBody GlobalRequest myData) {
		System.out.println("calling sortAccessories method");
		return AService.sortAsc(myData.getAcList());
	}

	@RequestMapping(value = "rest/sortDescAc", method = RequestMethod.POST)
	public @ResponseBody
	GlobalResponse gdesca(@RequestBody GlobalRequest myData) {
		System.out.println("calling sortDescAccessories method");
		return AService.sortAsc(myData.getAcList());
	}

	@RequestMapping(value = "rest/insertAccessories", method = RequestMethod.POST)
	public @ResponseBody
	GlobalResponse inserta(@RequestBody Accessory myData) {
		System.out.println("calling insertAccessories method");
		return AService.insertAccessory(myData);
	}
}
