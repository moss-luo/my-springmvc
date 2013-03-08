package com.isoftstone.wissdemo.biz.persons;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isoftstone.wissdemo.dao.CommoDao;
import com.isoftstone.wissdemo.vo.Person;

@Service
public class PersonsServiceImpl extends AbstractPersonService<Person>{
	
	@Autowired
	private CommoDao dbDao;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Person> selectList(Map<String, Object> params)throws Exception{
		return (List<Person>) dbDao.selectList("com.isoftstone.wissdemo.dao.PersonsMapper.list", params);
	}
	
	@Override
	public int total(Map<String, Object> parms) throws Exception {
		return (Integer) dbDao.selectOne("com.isoftstone.wissdemo.dao.PersonsMapper.total", parms);
	}

	@Override
	public Person insert(Person p) throws Exception {
		dbDao.insert("com.isoftstone.wissdemo.dao.PersonsMapper.addPerson", p);
		return p;
	}

	@Override
	public void delete(int[] ids) throws Exception {
		dbDao.delete("com.isoftstone.wissdemo.dao.PersonsMapper.deletePerson", ids);
	}

	@Override
	public void update(Person p) throws Exception {
		dbDao.update("com.isoftstone.wissdemo.dao.PersonsMapper.modifyPerson", p);
	}

	@Override
	public Person selectOne(int id) throws Exception {
		return (Person)dbDao.selectOne("com.isoftstone.wissdemo.dao.PersonsMapper.viewPerson", id);
	}
	
	
}
