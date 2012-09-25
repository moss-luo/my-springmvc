package com.isoftstone.wissdemo.biz.persons;

import java.util.List;

import com.isoftstone.wissdemo.vo.persons;

public interface PersonsService {
	public List<persons> queryPersons() throws Exception;
}
