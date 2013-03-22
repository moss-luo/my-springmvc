package com.isoftstone.agiledev.hrdemo.person.app.internal.person;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.isoftstone.agiledev.hrdemo.person.app.service.AbstractPersonService;
import com.isoftstone.agiledev.hrdemo.person.app.vo.Person;

@Service
public class PersonServiceImpl extends AbstractPersonService<Person>{
	
	@Resource
	private SqlSession sqlSession;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Person> selectList(Map<String, Object> params)throws Exception{
		return sqlSession.selectList("com.isoftstone.agiledev.hrdemo.person.app.PersonsMapper.list", params);
	}
	
	@Override
	public int total(Map<String, Object> parms) throws Exception {
		return (Integer) sqlSession.selectOne("com.isoftstone.agiledev.hrdemo.person.app.PersonsMapper.total", parms);
	}
	
	@Override
	public Person insert(Person p) throws Exception {
		sqlSession.insert("com.isoftstone.agiledev.hrdemo.person.app.PersonsMapper.addPerson", p);
		return p;
	}
	
	@Override
	public void delete(int[] ids) throws Exception {
		sqlSession.delete("com.isoftstone.agiledev.hrdemo.person.app.PersonsMapper.deletePerson", ids);
	}
	
	@Override
	public void update(Person p) throws Exception {
		sqlSession.update("com.isoftstone.agiledev.hrdemo.person.app.PersonsMapper.modifyPerson", p);
	}
	
	@Override
	public Person selectOne(int id) throws Exception {
		return (Person)sqlSession.selectOne("com.isoftstone.agiledev.hrdemo.person.app.PersonsMapper.viewPerson", id);
	}
	
	
}
