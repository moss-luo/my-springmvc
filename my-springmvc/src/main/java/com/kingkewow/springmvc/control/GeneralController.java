package com.kingkewow.springmvc.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kingkewow.springmvc.model.ParamModel;
import com.kingkewow.springmvc.model.UserModel;

@Controller
@RequestMapping("/views")
public class GeneralController {
	
	@RequestMapping(value="/index")
	public @ResponseBody Model execute( Model model){
		UserModel user = new UserModel("1","fangjing",23,"JANE");
		model.addAttribute("jane", user);
		System.out.println("index.jsp");
		return model;
	}
	
	@RequestMapping(value="/grid")
	public @ResponseBody Map<String,Object> queryUser(ParamModel pager ){
//		System.out.println(name);
		System.out.println(pager.getPage());
		UserModel user = new UserModel("1","测试名称1",23,"TEST");
		UserModel user2 = new UserModel("2","测试名称2",25,"TEST2");
		List<UserModel> list = new ArrayList<UserModel>();
		list.add(user);
		list.add(user2);
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("Total", 10);
		map.put("Rows", list);
		return map;
	}
	
	@RequestMapping("/param")
	public @ResponseBody Map<String,Object> param(@RequestParam("queryParams") Map<String, Object> queryParams/*URL传参，此处可以有多个传入参数*/){
		System.out.println(queryParams.get("name"));
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("Total", 10);
		map.put("Rows", queryParams);
		return map;
	}
	
	@RequestMapping("/upload")
	public @ResponseBody String upload(@RequestParam("name") String name,@RequestParam("file") MultipartFile file) throws Exception{
		System.out.println(name);
		if (!file.isEmpty()) {
			byte[] bytes = file.getBytes();
			// store the bytes somewhere
			return "success";
			} else {
			return "error";
			}
		
	}
}
