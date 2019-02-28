package com.service;

import java.util.List;

import com.model.CartObject;
import com.model.GlobalResponse;
import com.model.Laptop;

public interface LaptopService {
	
	public GlobalResponse getAllLaptops();
	public GlobalResponse getLBrands();
	public GlobalResponse getLColor();
	public GlobalResponse getLOpsys();
	public GlobalResponse insertLaptop(Laptop l);
	public GlobalResponse getLaptopInStock();
	public GlobalResponse sortAsc(List<Laptop> aclist);
	public GlobalResponse sortDesc(List<Laptop> aclist);
	public GlobalResponse updateLpStock(CartObject mydata);
}
 