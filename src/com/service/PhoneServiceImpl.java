package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.PhoneDao;
import com.model.CartObject;
import com.model.GlobalResponse;
import com.model.Phone;

@Service
public class PhoneServiceImpl implements PhoneService{
	@Autowired
	PhoneDao pDao;
	
	public GlobalResponse getAllPhones(){
		List<Phone> list = pDao.getAllPhones();
		return new GlobalResponse(list, null, true);
	}
	
	public GlobalResponse getPhBrands(){
		List<String> list = pDao.getPhBrands();
		System.out.println("Phone brands service layer");
		for(String s:list)
			System.out.println(s);
		return new GlobalResponse(list, null, true);
	}
	
	public GlobalResponse getPhOps()
	{		
		List<String> list = pDao.getPhOps();
		return new GlobalResponse(list, null, true);
	}

	public GlobalResponse getPhColors()
	{
		List<String> list = pDao.getPhColors();
		return new GlobalResponse(list, null, true);
	}

	
	public GlobalResponse insertPhone(Phone l){
		if(pDao.insertPhone(l)==1)
			return new GlobalResponse(null,true);
		else
			return new GlobalResponse(null,false);
	}
	
	public GlobalResponse getPhoneInStock(){
		List<Phone> list = pDao.getInStockPhone();
		return new GlobalResponse(list, null, true);
	}
	
	public GlobalResponse sortAsc(List<Phone> aclist){
		TreeSet<Phone> list = pDao.sortAsc(aclist);
		List<Phone> rlist=new ArrayList<Phone>();
		for(Phone a:list)
			rlist.add(a);
		return new GlobalResponse(list, null, true);
	}
	
	public GlobalResponse sortDesc(List<Phone> aclist){
		TreeSet<Phone> list = pDao.sortDesc(aclist);
		List<Phone> rlist=new ArrayList<Phone>();
		for(Phone a:list)
			rlist.add(a);
		return new GlobalResponse(rlist, null, true);
	}
	
	public GlobalResponse updatePhStock(CartObject co){
		if(pDao.updatePhStock(co)==1)
			return new GlobalResponse(null,true);
		else
			return new GlobalResponse(null,false);
	}
}
