package com.isoftstone.luckydraw.controller;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.isoftstone.luckydraw.biz.PersonsService;
import com.isoftstone.luckydraw.common.utils.ExportProvider;
import com.isoftstone.luckydraw.common.vo.Resultval;
import com.isoftstone.luckydraw.vo.Person;

@Controller
@RequestMapping
public class HelpController {
	@Resource
	private PersonsService personServiceImpl;
	
	@RequestMapping
	public void export(HttpServletResponse response){
		List<String> exportList = new ArrayList<String>();
		try {
			List<Person> winners = personServiceImpl.winners();
			String exportTitle = URLDecoder.decode("中奖名单", "UTF-8");
			
			for (Person p:winners) {
				exportList.add(ExportProvider.burdenDatum(p.getName()));
			}
			ExportProvider.export(exportList, exportTitle, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping
	public @ResponseBody Resultval reset(){
		Resultval result = null;
		try {
			personServiceImpl.reset();
			result = new Resultval(true,"success");
		} catch (Exception e) {
			e.printStackTrace();
			result = new Resultval(false,"error");
		}
		return result;
	}
}
