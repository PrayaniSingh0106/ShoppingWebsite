package com.dao;

import java.util.List;
import java.util.TreeSet;

import com.model.Accessory;
import com.model.CartObject;

public interface AccessoryDao {

	public List<Accessory> getAllAccessories();
	public List<Accessory> getAccessoriesOfType(String itype);
	public List<Accessory> getAccessoriesInStock();
	public List<Accessory> getAccessoriesInStock(String itype);
	public int insertAccessory(Accessory a);
	public int updateAcStock(CartObject myData);
	public TreeSet<Accessory> sortAsc(List<Accessory> aclist);
	public TreeSet<Accessory> sortDesc(List<Accessory> aclist);
	public List<String> getAcBrands();
	public List<String> getAcTypes();
}
