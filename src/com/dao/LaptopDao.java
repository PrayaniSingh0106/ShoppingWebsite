package com.dao;

import java.util.List;
import java.util.TreeSet;

import com.model.CartObject;
import com.model.Laptop;

public interface LaptopDao {

	public List<Laptop> getAllLaptops();
	public List<String> getLBrands();
	public List<String> getLColor();
	public List<String> getLOpsys();
	public int updateLpStock(CartObject co);
	public int insertLaptop(Laptop l);
	public List<Laptop> getLaptopInStock();
	public TreeSet<Laptop> sortAsc(List<Laptop> aclist);
	public TreeSet<Laptop> sortDesc(List<Laptop> aclist);

}
