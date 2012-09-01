package com.kingkewow.springmvc.dao;

import java.util.List;

public interface CommonDao {
	public List<?> selectList(String mapper,Object param) throws Exception;
	public Object selectOne(String mapper,Object param) throws Exception;
}
