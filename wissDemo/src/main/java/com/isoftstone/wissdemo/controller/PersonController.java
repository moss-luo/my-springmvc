package com.isoftstone.wissdemo.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.isoftstone.wissdemo.biz.persons.PersonsService;
import com.isoftstone.wissdemo.common.queryUtil.QueryExecutor;
import com.isoftstone.wissdemo.common.queryUtil.QueryTemplate;
import com.isoftstone.wissdemo.vo.Person;

@Controller
@RequestMapping
public class PersonController {
	@Resource
	private PersonsService personServiceImpl;

	@RequestMapping
	public @ResponseBody Map<String,Object> query(@RequestParam final Map<String,Object> queryParams) throws Exception{
		
		return QueryTemplate.query(queryParams, new QueryExecutor<Person>() {

			@Override
			public int total(Map<String, Object> params) throws Exception {
				return personServiceImpl.total(queryParams);
			}

			@Override
			public List<Person> list(Map<String, Object> params)throws Exception {
				return personServiceImpl.list(queryParams);
			}
		});
		
		 
	}
}
