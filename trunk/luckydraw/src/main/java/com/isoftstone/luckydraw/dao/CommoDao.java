package com.isoftstone.luckydraw.dao;

import java.util.List;

public interface CommoDao {
	public List<?> selectList(String mapper,Object param) throws Exception;
	public List<?> selectList(String mapper) throws Exception;
	public int selectOne(String mapper,Object param) throws Exception;
	public int update(String mapper,Object param) throws Exception;
	public int insert(String mapper,Object param) throws Exception;
	public int delete(String mapper,Object param) throws Exception;
}
