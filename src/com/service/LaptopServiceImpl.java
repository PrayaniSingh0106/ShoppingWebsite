package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.LaptopDao;
import com.model.CartObject;
import com.model.GlobalResponse;
import com.model.Laptop;

@Service
public class LaptopServiceImpl implements LaptopService {
	@Autowired
	LaptopDao lDao;
	
	public GlobalResponse getAllLaptops(){
		System.out.println("Inside laptop service");
		List<Laptop> list = lDao.getAllLaptops();
		return new GlobalResponse(list, null, true);
	}
	
	public GlobalResponse insertLaptop(Laptop l){
		if(lDao.insertLaptop(l)==1)
			return new GlobalResponse(null,true);
		else
			return new GlobalResponse(null,false);
	}
	
	public GlobalResponse getLaptopInStock(){
		List<Laptop> list = lDao.getLaptopInStock();
		return new GlobalResponse(list, null, true);
	}
	
	public GlobalResponse sortAsc(List<Laptop> aclist){
		TreeSet<Laptop> list = lDao.sortAsc(aclist);
		List<Laptop> rlist=new ArrayList<Laptop>();
		for(Laptop a:list)
			rlist.add(a);
		return new GlobalResponse(list, null, true);
	}
	
	public GlobalResponse sortDesc(List<Laptop> aclist){
		TreeSet<Laptop> list = lDao.sortDesc(aclist);
		List<Laptop> rlist=new ArrayList<Laptop>();
		for(Laptop a:list)
			rlist.add(a);
		return new GlobalResponse(rlist, null, true);
	}
	
	public GlobalResponse updateLpStock(CartObject co){
		if(lDao.updateLpStock(co)==1)
			return new GlobalResponse(null,true);
		else
			return new GlobalResponse(null,false);
	}

	@Override
	public GlobalResponse getLBrands() {
		// TODO Auto-generated method stub
		List<String> list = lDao.getLBrands();
		return new GlobalResponse(list, null, true);
	}

	@Override
	public GlobalResponse getLColor() {
		// TODO Auto-generated method stub
		List<String> list = lDao.getLColor();
		return new GlobalResponse(list, null, true);
	}

	@Override
	public GlobalResponse getLOpsys() {
		// TODO Auto-generated method stub
		List<String> list = lDao.getLOpsys();
		return new GlobalResponse(list, null, true);
	}
}
