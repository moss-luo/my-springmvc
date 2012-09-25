package com.isoftstone.wissdemo.biz.persons;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isoftstone.wissdemo.dao.CommoDao;
import com.isoftstone.wissdemo.vo.persons;

@Service
@SuppressWarnings("unchecked")
public class PersonsServiceImpl  implements PersonsService{
	@Autowired
	private CommoDao dbDao;
	@Override
	public List<persons> queryPersons() throws Exception {
		List<persons> list=new ArrayList<persons>();
		list=(List<persons>) dbDao.selectList("com.isoftstone.wissdemo.dao.PersonsMapper.queryPerson", null);
		return list;
	}
	public CommoDao getDbDao() {
		return dbDao;
	}
	public void setDbDao(CommoDao dbDao) {
		this.dbDao = dbDao;
	}
	
}
