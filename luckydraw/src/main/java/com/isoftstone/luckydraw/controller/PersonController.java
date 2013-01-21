package com.isoftstone.luckydraw.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.isoftstone.luckydraw.biz.PersonsService;
import com.isoftstone.luckydraw.common.utils.StringUtil;
import com.isoftstone.luckydraw.common.vo.Resultval;
import com.isoftstone.luckydraw.vo.Person;

@Controller
@RequestMapping
public class PersonController {
	@Resource
	private PersonsService personServiceImpl;

	@RequestMapping
	public @ResponseBody List<Person> list() throws Exception{
		List<Person> persons = personServiceImpl.list();
		System.out.println("剩余人数："+persons.size());
		List<Person> winners = personServiceImpl.winners();
		System.out.println("获奖人数："+winners.size());
		System.out.println("获奖名单：");
		for (int i = 0; i <winners.size(); i++) {
			System.out.print(winners.get(i).getName()+"||");
		}
		System.out.println();
		return persons;
	}
	
	@RequestMapping
	public @ResponseBody Resultval modify(String names){
		System.out.println("状态修改名单："+names);
		String[] temp=StringUtil.split(names);
		Resultval result = null;
		try {
			personServiceImpl.modify(temp);
			result = new Resultval(true,"success");
		} catch (Exception e) {
			e.printStackTrace();
			result = new Resultval(false,"error");
		}
		return result;
	}
	
	@RequestMapping
	public @ResponseBody List<Person> init() throws Exception{
		return  personServiceImpl.winners();
	}
}
