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

}
