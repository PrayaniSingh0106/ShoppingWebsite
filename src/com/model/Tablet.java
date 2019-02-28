package com.model;

public class Tablet {
	String id, name, frontimage,image, image1,image2,image3,brand,starrating,opSys,l1,l2,l3,l4,color; 
	double price;
	int stock;
	public Tablet() {
		super();
	}
	public Tablet(String id, String name, String frontimage, String image,
			String image1, String image2, String image3, String brand,
			String starrating, String opSys, String l1, String l2, String l3,
			String l4, double price, int stock, String color) {
		super();
		this.id = id;
		this.name = name;
		this.frontimage = frontimage;
		this.image = image;
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
		this.brand = brand;
		this.starrating = starrating;
		this.opSys = opSys;
		this.l1 = l1;
		this.l2 = l2;
		this.l3 = l3;
		this.l4 = l4;
		this.price = price;
		this.stock = stock;
		this.color=color;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFrontimage() {
		return frontimage;
	}
	public void setFrontimage(String frontimage) {
		this.frontimage = frontimage;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getImage1() {
		return image1;
	}
	public void setImage1(String image1) {
		this.image1 = image1;
	}
	public String getImage2() {
		return image2;
	}
	public void setImage2(String image2) {
		this.image2 = image2;
	}
	public String getImage3() {
		return image3;
	}
	public void setImage3(String image3) {
		this.image3 = image3;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getStarrating() {
		return starrating;
	}
	public void setStarrating(String starrating) {
		this.starrating = starrating;
	}
	public String getOpSys() {
		return opSys;
	}
	public void setOpSys(String opSys) {
		this.opSys = opSys;
	}
	public String getL1() {
		return l1;
	}
	public void setL1(String l1) {
		this.l1 = l1;
	}
	public String getL2() {
		return l2;
	}
	public void setL2(String l2) {
		this.l2 = l2;
	}
	public String getL3() {
		return l3;
	}
	public void setL3(String l3) {
		this.l3 = l3;
	}
	public String getL4() {
		return l4;
	}
	public void setL4(String l4) {
		this.l4 = l4;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Tablet [id=" + id + ", name=" + name + ", frontimage="
				+ frontimage + ", image=" + image + ", image1=" + image1
				+ ", image2=" + image2 + ", image3=" + image3 + ", brand="
				+ brand + ", starrating=" + starrating + ", opSys=" + opSys
				+ ", l1=" + l1 + ", l2=" + l2 + ", l3=" + l3 + ", l4=" + l4
				+ ", color=" + color + ", price=" + price + ", stock=" + stock
				+ "]";
	}
	
	
}
