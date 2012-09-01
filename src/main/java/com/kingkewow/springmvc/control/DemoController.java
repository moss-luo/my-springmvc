/**
 * 
 */
package com.kingkewow.springmvc.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kingkewow.springmvc.biz.UserService;
import com.kingkewow.springmvc.model.UserModel;

@Controller
@RequestMapping("/views/user")
public class DemoController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getUserList() {
		List<UserModel> list = new ArrayList<UserModel>();

		try {
			list = userService.queryUser();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Map<String, Object> modelMap = new HashMap<String, Object>(3);
		modelMap.put("total", "1");
		modelMap.put("data", list);
		modelMap.put("success", "true");
		return modelMap;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> addUser(@RequestBody UserModel model) {
		System.out.println(model.getUsername());
		Map<String, String> map = new HashMap<String, String>(1);
		map.put("success", "true");
		return map;
	}

	
}
