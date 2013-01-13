package com.isoftstone.wissdemo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.isoftstone.wissdemo.biz.persons.PersonsService;

@Controller
@RequestMapping
public class PersonController {
	@Resource
	private PersonsService personServiceImpl;

	@RequestMapping
	public @ResponseBody Map<String,Object> query(@RequestParam Map<String,Object> queryParams){
		Map<String,Object> result = new HashMap<String, Object>();
		queryParams.put("start", (Integer.parseInt((String) queryParams.get("page"))-1)
				*(Integer.parseInt((String) queryParams.get("rows"))));
		System.out.println(queryParams.get("start"));
		try {
			result.put("rows", personServiceImpl.list(queryParams));
			result.put("total", personServiceImpl.total(queryParams));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
