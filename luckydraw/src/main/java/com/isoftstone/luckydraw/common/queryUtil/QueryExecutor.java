package com.isoftstone.luckydraw.common.queryUtil;

import java.util.List;
import java.util.Map;

public interface QueryExecutor<T> {

	int total(Map<String, Object> params)throws Exception;
	
	List<T> list(Map<String, Object> params)throws Exception;

}
