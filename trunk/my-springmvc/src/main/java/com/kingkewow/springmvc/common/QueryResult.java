package com.kingkewow.springmvc.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryResult<T> {

	private int total;
	private List<T> data;
	
	public QueryResult(int total, List<T> data) {
		this.total = total;
		this.data = data;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}
	
	public Map<String , Object> exportResult(){
		Map<String , Object> result = new HashMap<String, Object>();
		result.put("Total", total);
		result.put("Rows", data);
		return result;
	}

}
