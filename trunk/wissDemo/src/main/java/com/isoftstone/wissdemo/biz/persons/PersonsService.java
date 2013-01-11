package com.isoftstone.wissdemo.biz.persons;

import java.util.List;
import java.util.Map;

import com.isoftstone.wissdemo.vo.Person;

public interface PersonsService {
	public List<Person> list(Map<String,Object> parms) throws Exception;
	
	public int total(Map<String,Object> parms) throws Exception;
}
