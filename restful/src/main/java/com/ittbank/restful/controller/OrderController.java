package com.ittbank.restful.controller;

import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ittbank.restful.util.TemplateResult;
import com.ittbank.restful.util.json.HttpStatusWithJsonView;
import com.ittbank.restful.vo.Phone;
import com.ittbank.restful.vo.UserArray;


/**
 * @RequestMapping("/order") 
 * 具有层次关系，方法级的将在类一级@RequestMapping之一, 如下面示例,
 * 访问方法级别的@RequestMapping("/index"),则URL为 /order/index
 * 
 *                           /order				=> index() 
 *                           /order/new 		=> _new() 
 *                           /order/{id}		=> show() 
 *                           /order/{id}/edit 	=> edit() 
 *                           /order 		POST 		=>create() 
 *                           /order/{id} 	PUT 		=> update() 
 *                           /order/{id}	DELETE 		=> delete() 
 *                           /order 		DELETE		=> batchDelete()
 */
@Controller
@RequestMapping("/order")
public class OrderController {
	
	Phone phone2 = new Phone(1,"motorola-xoom","resources/img/phones/motorola-xoom.0.jpg","MOTOROLA XOOM\u2122",
			"The Next, Next Generation\n\nExperience the future with MOTOROLA XOOM," +
			"the worlds first tablet powered by Android 3.0 (Honeycomb).","MOTOROLA XOOM has a super-powerful dual-core processor and Android");

	/** 列表 */
	@RequestMapping(value = "")
	public TemplateResult index(HttpServletResponse resp) {
		TemplateResult tr = new TemplateResult(HttpStatus.SC_OK, phone2);
		return tr;
	}

	/** 进入新增 */
	@RequestMapping(value = "/new")
	public ModelAndView _new() {
		return null;
	}

	/** 显示一条数据 */
	@RequestMapping(value = "/{id}")
	public @ResponseBody
	String show(@PathVariable long id) {
		System.out.println("show");
		return "OK";
	}

	/** 编辑 */
	@RequestMapping(value = "/edit/{id}")
	public ModelAndView edit(@PathVariable long id) {
		ModelMap model = new ModelMap();
		model.put("name", "fangjun");
		model.put("name2", "james");
		model.put("httpstatus", 201);
		return new ModelAndView(new HttpStatusWithJsonView(), model);
	}

	/**
	 * 保存新增 注明：不使用add() 方法是由于add这个方法会被maxthon浏览器当做广告链接过滤掉,因为包含ad字符
	 **/
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String create(HttpServletResponse resp) {
		resp.setStatus(HttpStatus.SC_NOT_MODIFIED);
		return "create method";
	}

	/** 保存更改 */
	@RequestMapping(method = RequestMethod.PUT)
	public ModelAndView update() {
		return null;
	}

	/** 删除单个 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ModelAndView delete(@PathVariable long id) {
		return null;
	}

	/** 批量删除 */
	@RequestMapping(method = RequestMethod.DELETE)
	public ModelAndView batchDelete(@RequestParam("items") Long[] items) {
		return null;
	}
	/**
	 * 测试springmvc如何传数组参数
	 * @param users
	 * @return
	 */
	@RequestMapping("list")
	public @ResponseBody String list(UserArray users){
		System.out.println("list");
		return "success";
	}

}
