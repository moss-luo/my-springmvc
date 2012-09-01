package com.kingkewow.springmvc.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kingkewow.springmvc.model.UserModel;

@Controller
public class GeneralController {
	
	@RequestMapping(value="/index")
	public @ResponseBody Model execute( Model model){
		UserModel user = new UserModel("1","fangjing",23,"JANE");
		model.addAttribute("jane", user);
		System.out.println("index.jsp");
		return model;
	}
	
	@RequestMapping(value="/user")
	public @ResponseBody Map<String,Object> queryUser( UserModel u){
		System.out.println(u.getUsername());
		UserModel user = new UserModel("1","fangjing",23,"JANE");
		UserModel user2 = new UserModel("2","kingkewow",25,"JA");
		List<UserModel> list = new ArrayList<UserModel>();
		list.add(user);
		list.add(user2);
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("Total", 10);
		map.put("Rows", list);
		return map;
	}
}
