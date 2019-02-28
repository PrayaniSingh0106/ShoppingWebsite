package com.service;

import java.util.List;

import com.model.CartObject;
import com.model.GlobalResponse;
import com.model.Tablet;

public interface TabletService {
	
	public GlobalResponse getAllTablets();
	public GlobalResponse getTBrands();
	public GlobalResponse getTColor();
	public GlobalResponse getTOpsys();
	public GlobalResponse insertTablet(Tablet l);
	public GlobalResponse getTabletInStock();
	public GlobalResponse sortAsc(List<Tablet> aclist);
	public GlobalResponse sortDesc(List<Tablet> aclist);
	public GlobalResponse updateTbStock(CartObject mydata);
}
