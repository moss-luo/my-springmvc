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
	Map<String, Object> grid(ParamModel pager) {
		UserModel user = new UserModel("1", "测试名称1", 23, "TEST");
		UserModel user2 = new UserModel("2", "测试名称2", 25, "TEST2");
		List<UserModel> list = new ArrayList<UserModel>();
		list.add(user);
		list.add(user2);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", 10);
		map.put("rows", list);
		return map;
	}

	@RequestMapping
	public @ResponseBody OperationPrompt delete(@RequestParam("ids") String ids) {
		return new OperationPrompt("删除操作成功！",true);
	}

	@RequestMapping
	public @ResponseBody
	String upload(@RequestParam("name") String name,
			@RequestParam("file") MultipartFile file) throws Exception {
		if (!file.isEmpty()) {
			byte[] bytes = file.getBytes();
			// store the bytes somewhere
			return "success";
		} else {
			return "error";
		}

	}
}
