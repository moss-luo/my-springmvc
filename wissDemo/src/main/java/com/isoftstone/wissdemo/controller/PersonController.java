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
import com.isoftstone.wissdemo.common.utils.StringUtil;
import com.isoftstone.wissdemo.common.vo.Resultval;
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
	
	@RequestMapping
	public @ResponseBody Resultval add(Person p){
		try {
			personServiceImpl.add(p);
		} catch (Exception e) {
			return new Resultval(false,"新增失败，请稍候重试!");
		}
		return new Resultval(true,"新增成功!");
	}
	
	@RequestMapping
	public @ResponseBody Resultval delete(String ids){
		try {
			personServiceImpl.delete(StringUtil.stringformatArray(ids));
		} catch (Exception e) {
			return new Resultval(false,"删除失败，请稍候重试!");
		}
		return new Resultval(true,"删除成功!");
	}
	
	@RequestMapping
	public @ResponseBody Resultval modify(Person p){
		try {
			personServiceImpl.modify(p);
		} catch (Exception e) {
			return new Resultval(false,"修改失败，请稍候重试");
		}
		return new Resultval(true,"修改成功");
	}
}
