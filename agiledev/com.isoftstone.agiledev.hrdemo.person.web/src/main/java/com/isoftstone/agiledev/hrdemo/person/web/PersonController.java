package com.isoftstone.agiledev.hrdemo.person.web;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.isoftstone.agiledev.core.query.QueryExecutor;
import com.isoftstone.agiledev.core.query.QueryParameters;
import com.isoftstone.agiledev.core.query.QueryResult;
import com.isoftstone.agiledev.core.query.QueryTemplate;
import com.isoftstone.agiledev.hrdemo.person.app.service.PersonService;
import com.isoftstone.agiledev.hrdemo.person.app.vo.Person;

@Controller
@RequestMapping
public class PersonController {
	@Resource
	private PersonService<Person> personServiceImpl;

	@RequestMapping
	public QueryResult<Person> query(QueryParameters queryParameters) throws Exception{
		return QueryTemplate.query(queryParameters, new QueryExecutor<Person>() {
			List<Person> list = null;
			@Override
			public List<Person> getResult(int start, int end, String orderBy) {
				try {
					Map<String,Object> params = new HashMap<String, Object>();
					params.put("start", start);
					params.put("rows", end-start);
					 list = personServiceImpl.selectList(params);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return list;
			}

			@Override
			public int getTotal() {
				try {
					return personServiceImpl.total(null);
				} catch (Exception e) {
					e.printStackTrace();
					return 0;
				}
			}
			
		});
	}
	
	
	@RequestMapping
	public void upload(@RequestParam("file") CommonsMultipartFile file,HttpServletResponse response)throws Exception{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = null;
		pw = response.getWriter();
		if(file.getSize()>0){
			pw.print("上传成功");
		}else{
			pw.print("上传失败");
		}
	}	
}
