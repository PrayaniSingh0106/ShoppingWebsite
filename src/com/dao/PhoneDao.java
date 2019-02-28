package com.dao;

import java.util.List;
import java.util.TreeSet;

import com.model.CartObject;
import com.model.Phone;

public interface PhoneDao {
	public List<String> getPhBrands();

	public List<Phone> getAllPhones();

	public List<Phone> getInStockPhone();

	public int insertPhone(Phone p);

	public int getPhoneStock(String id);

	public int updatePhStock(CartObject myData);

	public TreeSet<Phone> sortAsc(List<Phone> aclist);

	public TreeSet<Phone> sortDesc(List<Phone> aclist);

	public List<String> getPhOps();

	public List<String> getPhColors();
}
