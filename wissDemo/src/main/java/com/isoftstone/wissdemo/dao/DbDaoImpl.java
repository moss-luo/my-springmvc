package com.isoftstone.wissdemo.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;
@Repository
public class DbDaoImpl extends SqlSessionDaoSupport implements CommoDao {

	@Override
	public List<?> selectList(String mapper, Object param) throws Exception {
		return this.getSqlSession().selectList(mapper, param);
	}

	@Override
	public Object selectOne(String mapper, Object param) throws Exception {
		return this.getSqlSession().selectOne(mapper, param);
	}

	@Override
	public int update(String mapper, Object param) throws Exception {
		return this.getSqlSession().update(mapper, param);
	}

	@Override
	public int insert(String mapper, Object param) throws Exception {
		return this.getSqlSession().insert(mapper, param);
	}

	@Override
	public int delete(String mapper, Object param) throws Exception {
		return this.getSqlSession().delete(mapper, param);
	}

}
