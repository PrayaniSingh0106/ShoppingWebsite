package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.CartObject;
import com.model.GlobalResponse;
import com.service.AccessoryService;
import com.service.LaptopService;
import com.service.PhoneService;
import com.service.TabletService;

@Controller
public class ProjectController {
	@Autowired
	private AccessoryService AService;
	@Autowired
	private LaptopService LService;
	@Autowired
	private PhoneService PService;
	@Autowired
	private TabletService TService;

	@RequestMapping(value = "rest/updateStock", method = RequestMethod.POST)
	public @ResponseBody
	GlobalResponse stockUpdate(@RequestBody List<CartObject> myData) {
		System.out.println("calling update stock method");
		GlobalResponse res = new GlobalResponse();
		for (CartObject c : myData) {
			char ch = c.getId().charAt(0);
			switch (ch) {
			case 'A':
				res=AService.updateAcStock(c);
			case 'M':
				res=PService.updatePhStock(c);
			case 'L':
				res=LService.updateLpStock(c);
			case 'T':
				res=TService.updateTbStock(c);
			}
		}
		return res;
	}
}
