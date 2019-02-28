package com.model;

public class GlobalResponse {
	private String message;
	private boolean successFlag;
	private Object resultData;



	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccessFlag() {
		return successFlag;
	}

	public void setSuccessFlag(boolean successFlag) {
		this.successFlag = successFlag;
	}

	public Object getResultData() {
		return resultData;
	}

	public void setResultData(Object resultData) {
		this.resultData = resultData;
	}

	public GlobalResponse() {
		super();
	}

	public GlobalResponse(Object resultData, String message, boolean successFlag) {
		super();
		this.message = message;
		this.successFlag = successFlag;
		this.resultData = resultData;
	}

	public GlobalResponse(String message, boolean successFlag) {
		super();
		this.message = message;
		this.successFlag = successFlag;
	}
	
	
}
