package com.model;

public class CartObject {
	String id;
	int qty;
	public CartObject(String id, int quantity) {
		super();
		this.id = id;
		this.qty = quantity;
	}
	public CartObject() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int quantity) {
		this.qty = quantity;
	}
	
}
