package com.model;

import java.util.List;

public class GlobalRequest {
private String reqData;
private double lowerP,upperP;
private List<Accessory> acList;

public GlobalRequest() {
	super();
}

public GlobalRequest(String reqData) {
	super();
	this.reqData = reqData;
}

public String getReqData() {
	return reqData;
}

public void setReqData(String reqData) {
	this.reqData = reqData;
}

public double getLowerP() {
	return lowerP;
}

public void setLowerP(double lowerP) {
	this.lowerP = lowerP;
}

public double getUpperP() {
	return upperP;
}

public void setUpperP(double upperP) {
	this.upperP = upperP;
}

public GlobalRequest(double lowerP, double upperP) {
	super();
	this.lowerP = lowerP;
	this.upperP = upperP;
}

public GlobalRequest(double upperP) {
	super();
	this.upperP = upperP;
}

public List<Accessory> getAcList() {
	return acList;
}

public void setAcList(List<Accessory> acList) {
	this.acList = acList;
}

public GlobalRequest(List<Accessory> acList) {
	super();
	this.acList = acList;
}


}
