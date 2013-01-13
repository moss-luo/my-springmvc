package com.isoftstone.wissdemo.common.queryUtil;

import java.util.HashMap;
import java.util.Map;


public class QueryTemplate {
	
	public static Map<String,Object> query(Map<String, Object> queryParams,QueryExecutor<?> executor) throws Exception{
		
		queryParams.put("start", (Integer.parseInt((String) queryParams.get("page"))-1)
				* (Integer.parseInt((String) queryParams.get("rows"))));
		
		Map<String,Object> result = new HashMap<String, Object>();
		
		result.put("total", executor.total(queryParams));
		result.put("rows",  executor.list(queryParams));
		
		return result;
	}

}
