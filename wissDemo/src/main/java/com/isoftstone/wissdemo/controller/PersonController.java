package com.isoftstone.wissdemo.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping
public class PersonController {

	@RequestMapping
	public @ResponseBody Map<String,Object> query(){
		System.out.println("123");
		return null;
	}
}
