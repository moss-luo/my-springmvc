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
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.kingkewow.springmvc.common.OperationPrompt;
import com.kingkewow.springmvc.model.ParamModel;
import com.kingkewow.springmvc.model.UserModel;

@Controller
@RequestMapping
public class GeneralController {

	@RequestMapping
	public @ResponseBody
	Model execute(Model model) {
		UserModel user = new UserModel("1", "fangjing", 23, "JANE");
		model.addAttribute("jane", user);
		System.out.println("index.jsp");
		return model;
	}

	@RequestMapping
	public @ResponseBody
	Map<String, Object> grid(@RequestParam(value="username", required=false) final String username,ParamModel pager) {
		System.out.println(username);
		UserModel user = new UserModel("1", "测试名称1", 23, "TEST");
		UserModel user2 = new UserModel("2", "测试名称2", 25, "TEST2");
		UserModel user3 = new UserModel("3", "测试名称3", 23, "TEST3");
		UserModel user4 = new UserModel("4", "测试名称4", 25, "TEST4");
		List<UserModel> list = new ArrayList<UserModel>();
		list.add(user);
		list.add(user2);
		list.add(user3);
		list.add(user4);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", 4);
		map.put("rows", list);
		return map;
	}

	@RequestMapping
	public @ResponseBody OperationPrompt delete(@RequestParam("ids") String ids) {
		return new OperationPrompt("删除操作成功！",true);
	}
	
	@RequestMapping
	public @ResponseBody OperationPrompt add(UserModel user) {
		System.out.println(user.getUsername());
		return new OperationPrompt("新增操作成功！",true);
	}
	
	@RequestMapping
	public @ResponseBody OperationPrompt modify(UserModel user) {
		System.out.println(user.getUsername());
		return new OperationPrompt("修改操作成功！",true);
	}

	@SuppressWarnings("unused")
	@RequestMapping
	public @ResponseBody String upload(@RequestParam("file") CommonsMultipartFile file) throws Exception {
		if (!file.isEmpty()) {
			byte[] bytes = file.getBytes();
			// store the bytes somewhere
			return "success";
		} else {
			return "error";
		}

	}
}
