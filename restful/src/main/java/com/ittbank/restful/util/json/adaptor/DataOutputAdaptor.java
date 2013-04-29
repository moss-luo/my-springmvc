package com.ittbank.restful.util.json.adaptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface DataOutputAdaptor {
	void output(HttpServletRequest req,HttpServletResponse resp,Object obj);
	boolean check(Object obj);
	void setType(String type);
	String getType();
}
