package com.ittbank.restful.util;

public class TemplateResult {
	
	private int httpStatus = 200;
	private Object model;
	public TemplateResult(){}
	public TemplateResult(int httpStatus,Object model){
		this.httpStatus = httpStatus;
		if(model != null){
			this.model=model;
		}
	}
	public int getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(int httpStatus) {
		this.httpStatus = httpStatus;
	}
	public Object getModel() {
		return model;
	}
	public void setModel(Object model) {
		this.model = model;
	}

}
