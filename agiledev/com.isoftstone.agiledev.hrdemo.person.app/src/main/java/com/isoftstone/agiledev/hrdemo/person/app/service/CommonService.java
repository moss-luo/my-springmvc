package com.isoftstone.agiledev.hrdemo.person.app.service;

import java.util.List;
import java.util.Map;


/**
 * 公共service接口，包含6个基本方法。
 * 查询多条，查询单条，新增，修改，删除，查询总数
 * test方法为了展示抽象类的作用
 * @author luoting
 *
 */
public interface CommonService<E> {
	
	List<E> selectList(Map<String, Object> parms)throws Exception;
	
	E selectOne(int id)throws Exception;
	
	E insert(E e)throws Exception;
	
	void delete(int[] o)throws Exception;
	
	void update(E o)throws Exception;

	int total(Map<String,Object> parms) throws Exception;
	
	void test();
}
