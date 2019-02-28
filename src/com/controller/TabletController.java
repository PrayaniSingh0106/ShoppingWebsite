package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.GlobalResponse;
import com.model.Tablet;
import com.service.TabletService;

@Controller
public class TabletController {
	@Autowired
	private TabletService LService;

	
	@RequestMapping(value = "rest/getTablets", method = RequestMethod.GET)
	public @ResponseBody
	GlobalResponse gt() {
		System.out.println("calling get Tablets method");
		return LService.getAllTablets();
	}
	
	@RequestMapping(value = "rest/getTBrands", method = RequestMethod.GET)
	public @ResponseBody
	GlobalResponse gtb() {
		System.out.println("calling get Tablets Brands method");
		return LService.getTBrands();
	}
	
	@RequestMapping(value = "rest/getTColor", method = RequestMethod.GET)
	public @ResponseBody
	GlobalResponse gtc() {
		System.out.println("calling get Tablets Color method");
		return LService.getTColor();
	}
	
	@RequestMapping(value = "rest/getTOpsys", method = RequestMethod.GET)
	public @ResponseBody
	GlobalResponse gto() {
		System.out.println("calling get Tablets Opsys method");
		return LService.getTOpsys();
	}

	@RequestMapping(value = "rest/getStockedTablets", method = RequestMethod.GET)
	public @ResponseBody GlobalResponse gst() {
		System.out.println("calling getTabletsInStock method");
		return LService.getTabletInStock();
	}

	@RequestMapping(value = "rest/sortTablets", method = RequestMethod.POST)
	public @ResponseBody
	GlobalResponse gsortt(@RequestBody List<Tablet> myData) {
		System.out.println("calling sortTablets method");
		return LService.sortAsc(myData);
	}

	@RequestMapping(value = "rest/sortDescTb", method = RequestMethod.POST)
	public @ResponseBody
	GlobalResponse gdesct(@RequestBody List<Tablet> myData) {
		System.out.println("calling sortDescTablets method");
		return LService.sortAsc(myData);
	}

	@RequestMapping(value = "rest/insertTablets", method = RequestMethod.POST)
	public @ResponseBody
	GlobalResponse insertt(@RequestBody Tablet myData) {
		System.out.println("calling insertTablet method");
		return LService.insertTablet(myData);
	}

}
