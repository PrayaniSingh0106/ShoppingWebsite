package com.dao;

import java.util.List;
import java.util.TreeSet;

import com.model.CartObject;
import com.model.Tablet;

public interface TabletDao {
	
	public List<Tablet> getAllTablets();
	public List<String> getTBrands();
	public List<String> getTColor();
	public List<String> getTOpsys();
	public List<Tablet> getInStockTablet();
	public int insertTablet(Tablet p);
	public int getTabletStock(String id);
	public int updateTbStock(CartObject myData);
	public TreeSet<Tablet> sortAsc(List<Tablet> aclist);
	public TreeSet<Tablet> sortDesc(List<Tablet> aclist);
}
