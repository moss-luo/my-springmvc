package com.kingkewow.springmvc.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;
/**
 * @author luoting
 *
 */
@Repository
public class DbDaoImpl extends SqlSessionDaoSupport implements CommonDao {

	@Override
	public List<?> selectList(String mapper, Object param) throws Exception {
		return this.getSqlSession().selectList(mapper, param);
	}

	@Override
	public Object selectOne(String mapper, Object param) throws Exception {
		return this.selectOne(mapper, param);
	}

}
