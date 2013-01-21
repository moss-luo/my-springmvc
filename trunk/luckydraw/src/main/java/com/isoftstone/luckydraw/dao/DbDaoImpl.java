package com.isoftstone.luckydraw.dao;

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
	public List<?> selectList(String mapper) throws Exception {
		return this.getSqlSession().selectList(mapper);
	}
	@Override
	public int selectOne(String mapper, Object param) throws Exception {
		return (Integer) this.getSqlSession().selectOne(mapper, param);
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
