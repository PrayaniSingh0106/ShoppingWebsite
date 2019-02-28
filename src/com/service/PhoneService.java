package com.service;

import java.util.List;

import com.model.CartObject;
import com.model.GlobalResponse;
import com.model.Phone;

public interface PhoneService {
	public GlobalResponse getPhBrands();
	public GlobalResponse getAllPhones();
	public GlobalResponse insertPhone(Phone l);
	public GlobalResponse getPhoneInStock();
	public GlobalResponse sortAsc(List<Phone> aclist);
	public GlobalResponse sortDesc(List<Phone> aclist);
	public GlobalResponse updatePhStock(CartObject mydata);
	public GlobalResponse getPhOps();
	public GlobalResponse getPhColors();
}
