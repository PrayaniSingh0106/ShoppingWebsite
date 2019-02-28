package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.TabletDao;
import com.model.CartObject;
import com.model.GlobalResponse;
import com.model.Tablet;

@Service
public class TabletServiceImpl implements TabletService {
	@Autowired
	TabletDao tDao;
	
	public GlobalResponse getAllTablets(){
		List<Tablet> list = tDao.getAllTablets();
		return new GlobalResponse(list, null, true);
	}
	
	public GlobalResponse insertTablet(Tablet l){
		if(tDao.insertTablet(l)==1)
			return new GlobalResponse(null,true);
		else
			return new GlobalResponse(null,false);
	}
	
	public GlobalResponse getTabletInStock(){
		List<Tablet> list = tDao.getInStockTablet();
		return new GlobalResponse(list, null, true);
	}
	
	public GlobalResponse sortAsc(List<Tablet> aclist){
		TreeSet<Tablet> list = tDao.sortAsc(aclist);
		List<Tablet> rlist=new ArrayList<Tablet>();
		for(Tablet a:list)
			rlist.add(a);
		return new GlobalResponse(list, null, true);
	}
	
	public GlobalResponse sortDesc(List<Tablet> aclist){
		TreeSet<Tablet> list = tDao.sortDesc(aclist);
		List<Tablet> rlist=new ArrayList<Tablet>();
		for(Tablet a:list)
			rlist.add(a);
		return new GlobalResponse(rlist, null, true);
	}
	
	public GlobalResponse updateTbStock(CartObject co){
		if(tDao.updateTbStock(co)==1)
			return new GlobalResponse(null,true);
		else
			return new GlobalResponse(null,false);
	}

	@Override
	public GlobalResponse getTBrands() {
		// TODO Auto-generated method stub
		List<String> list = tDao.getTBrands();
		return new GlobalResponse(list, null, true);
	}

	@Override
	public GlobalResponse getTColor() {
		// TODO Auto-generated method stub
		List<String> list = tDao.getTColor();
		return new GlobalResponse(list, null, true);
	}

	@Override
	public GlobalResponse getTOpsys() {
		// TODO Auto-generated method stub
		List<String> list = tDao.getTOpsys();
		return new GlobalResponse(list, null, true);
	}

}
