package com.isoftstone.wissdemo.dao;

import java.util.List;

public interface CommoDao {
	public List<?> selectList(String mapper,Object param) throws Exception;
}
