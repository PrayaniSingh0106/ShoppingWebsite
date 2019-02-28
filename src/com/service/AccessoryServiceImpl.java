package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.AccessoryDao;
import com.model.Accessory;
import com.model.CartObject;
import com.model.GlobalResponse;

@Service
public class AccessoryServiceImpl implements AccessoryService{
	@Autowired
	AccessoryDao ADao;

	public GlobalResponse getAllAccessories() {
		List<Accessory> list = ADao.getAllAccessories();
		return new GlobalResponse(list, null, true);
	}
	
	public GlobalResponse getAccessoriesOfType(String itype){
		List<Accessory> list = ADao.getAccessoriesOfType(itype);
		return new GlobalResponse(list, null, true);
	}
	
	public GlobalResponse getAcBrands()
	{
		List<String> list = ADao.getAcBrands();
		return new GlobalResponse(list, null, true);
	}

	public GlobalResponse getAcTypes()
	{
		List<String> list = ADao.getAcTypes();
		return new GlobalResponse(list, null, true);
	}

	public GlobalResponse getAccessoriesInStock(){
		List<Accessory> list = ADao.getAccessoriesInStock();
		return new GlobalResponse(list, null, true);
	}
	public GlobalResponse getAccessoriesInStock(String itype){
		List<Accessory> list = ADao.getAccessoriesInStock(itype);
		return new GlobalResponse(list, null, true);
	}
	public GlobalResponse insertAccessory(Accessory a){
		if(ADao.insertAccessory(a)==1)
			return new GlobalResponse(null,true);
		else
			return new GlobalResponse(null,false);
	}
	public GlobalResponse updateAcStock(CartObject myData){
		if(ADao.updateAcStock(myData)==1)
			return new GlobalResponse(null,true);
		else
			return new GlobalResponse(null,false);
	}
	public GlobalResponse sortAsc(List<Accessory> aclist){
		TreeSet<Accessory> list = ADao.sortAsc(aclist);
		List<Accessory> rlist=new ArrayList<Accessory>();
		for(Accessory a:list)
			rlist.add(a);
		return new GlobalResponse(list, null, true);
	}
	public GlobalResponse sortDesc(List<Accessory> aclist){
		TreeSet<Accessory> list = ADao.sortDesc(aclist);
		List<Accessory> rlist=new ArrayList<Accessory>();
		for(Accessory a:list)
			rlist.add(a);
		return new GlobalResponse(rlist, null, true);
	}
}
