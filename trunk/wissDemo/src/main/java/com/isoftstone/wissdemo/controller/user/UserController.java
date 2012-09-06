package com.isoftstone.wissdemo.controller.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.isoftstone.wissdemo.vo.User;

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping("query")
	public @ResponseBody Map<String,Object> query(){
		User u1 = new User(1,"张三",22,"中国广东","华为");
		User u2 = new User(2,"张四",23,"中国香港","软通");
		User u3 = new User(3,"张五",24,"中国湖南","华为");
		User u4 = new User(4,"刘一",25,"中国四川","软通");
		User u5 = new User(5,"里斯",26,"中国云南","软通");
		User u11 = new User(1,"张三",22,"中国广东","华为");
		User u21 = new User(2,"张四",23,"中国香港","软通");
		User u31 = new User(3,"张五",24,"中国湖南","华为");
		User u41 = new User(4,"刘一",25,"中国四川","软通");
		User u51 = new User(5,"里斯",26,"中国云南","软通");
		User u12 = new User(1,"张三",22,"中国广东","华为");
		User u22 = new User(2,"张四",23,"中国香港","软通");
		User u32 = new User(3,"张五",24,"中国湖南","华为");
		User u42 = new User(4,"刘一",25,"中国四川","软通");
		User u52 = new User(5,"里斯",26,"中国云南","软通");
		
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
