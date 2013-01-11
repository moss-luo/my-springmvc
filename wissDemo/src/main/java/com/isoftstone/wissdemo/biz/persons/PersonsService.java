package com.isoftstone.wissdemo.biz.persons;

import java.util.List;
import java.util.Map;

import com.isoftstone.wissdemo.vo.persons;

public interface PersonsService {
	public List<persons> list(Map<String,Object> parms) throws Exception;
	
	public int total(Map<String,Object> parms) throws Exception;
}
