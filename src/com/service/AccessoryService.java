package com.service;

import java.util.List;

import com.model.Accessory;
import com.model.CartObject;
import com.model.GlobalResponse;

public interface AccessoryService {

	public GlobalResponse getAllAccessories();
	public GlobalResponse getAccessoriesOfType(String itype);
	public GlobalResponse getAccessoriesInStock();
	public GlobalResponse getAccessoriesInStock(String itype);
	public GlobalResponse insertAccessory(Accessory a);
	public GlobalResponse updateAcStock(CartObject mydata);
	public GlobalResponse sortAsc(List<Accessory> aclist);
	public GlobalResponse sortDesc(List<Accessory> aclist);
	public GlobalResponse getAcBrands();
	public GlobalResponse getAcTypes();
}
