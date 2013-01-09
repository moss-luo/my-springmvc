package com.isoftstone.wissdemo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.isoftstone.wissdemo.vo.User;

@Controller
@RequestMapping
public class InfoController {
	
	@RequestMapping
	public @ResponseBody Map<String,Object> getInfo(){

		User u1 = new User(123456,"张三",1001016,"2012.09.01 09:05","出");
		User u2 = new User(252589,"张四",1006589,"2012.09.01 09:05","进");
		User u3 = new User(343524,"张五",1006584,"2012.09.01 09:05","出");
		User u4 = new User(432245,"刘一",10065844,"2012.09.01 09:05","进");
		User u5 = new User(563321,"里斯",10065847,"2012.09.01 09:05","进");
		User u11 = new User(123456,"张三",1001016,"2012.09.01 09:05","出");
		User u21 = new User(245244,"张四",1006589,"2012.09.01 09:05","进");
		User u31 = new User(323424,"张五",1006584,"2012.09.01 09:05","出");
		User u41 = new User(474534,"刘一",10065844,"2012.09.01 09:05","进");
		User u51 = new User(546732,"里斯",10065847,"2012.09.01 09:05","进");
		User u12 = new User(123456,"张三",1001016,"2012.09.01 09:05","出");
		User u22 = new User(245345,"张四",1006589,"2012.09.01 09:05","进");
		User u32 = new User(323454,"张五",1006584,"2012.09.01 09:05","出");
		User u42 = new User(487352,"刘一",10065844,"2012.09.01 09:05","进");
		User u52 = new User(523426,"里斯",10065847,"2012.09.01 09:05","进");
		
		List<User> list = new ArrayList<User>();
		
		list.add(u1);
		list.add(u2);
		list.add(u3);
		list.add(u4);
		list.add(u5);
		list.add(u11);
		list.add(u21);
		list.add(u31);
		list.add(u41);
		list.add(u51);
		list.add(u12);
		list.add(u22);
		list.add(u32);
		list.add(u42);
		list.add(u52);
		
		Map<String, Object> json = new HashMap<String, Object>();
		json.put("Total", 15);
		json.put("Rows", list);
		
		return json;
	}
}
