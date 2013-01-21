package com.isoftstone.luckydraw.biz;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.isoftstone.luckydraw.dao.CommoDao;
import com.isoftstone.luckydraw.vo.Person;

@SuppressWarnings("unchecked")
@Service
public class PersonsServiceImpl  implements PersonsService{
	
	@Autowired
	private CommoDao dbDao;
	
	@Override
	public List<Person> list() throws Exception {
		return (List<Person>) dbDao.selectList("com.isoftstone.luckydraw.dao.personsMapper.list");
	}

	@Override
	public void modify(String[] names) throws Exception {
		for (int i = 0; i < names.length; i++) {
			dbDao.update("com.isoftstone.luckydraw.dao.personsMapper.modify",names[i]);
		}
	}

	@Override
	public List<Person> winners() throws Exception {
		return (List<Person>) dbDao.selectList("com.isoftstone.luckydraw.dao.personsMapper.winners");
	}

	@Override
	public void reset() throws Exception {
		dbDao.update("com.isoftstone.luckydraw.dao.personsMapper.reset",null);
	}
	
}
