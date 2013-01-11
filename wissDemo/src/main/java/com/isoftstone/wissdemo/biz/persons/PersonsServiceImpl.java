package com.isoftstone.wissdemo.biz.persons;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isoftstone.wissdemo.dao.CommoDao;
import com.isoftstone.wissdemo.vo.Person;

@Service
public class PersonsServiceImpl  implements PersonsService{
	
	@Autowired
	private CommoDao dbDao;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Person> list(Map<String, Object> params) throws Exception {
		return (List<Person>) dbDao.selectList("com.isoftstone.wissdemo.dao.PersonsMapper.list", params);
	}
	
	@Override
	public int total(Map<String, Object> parms) throws Exception {
		return dbDao.selectOne("com.isoftstone.wissdemo.dao.PersonsMapper.total", parms);
	}
	
	
}
