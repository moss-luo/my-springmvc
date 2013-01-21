package com.isoftstone.luckydraw.biz;

import java.util.List;
import com.isoftstone.luckydraw.vo.Person;

public interface PersonsService {
	public List<Person> list() throws Exception;
	public void modify(String[] name) throws Exception;
	public List<Person> winners() throws Exception;
	public void reset() throws Exception;
	
}
