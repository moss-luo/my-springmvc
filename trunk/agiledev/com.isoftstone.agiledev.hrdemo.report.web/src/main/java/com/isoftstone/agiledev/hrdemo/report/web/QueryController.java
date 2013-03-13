package com.isoftstone.agiledev.hrdemo.report.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.isoftstone.agiledev.core.query.QueryParameters;
import com.isoftstone.agiledev.core.query.QueryResult;
import com.isoftstone.agiledev.core.tree.Node;
import com.isoftstone.agiledev.core.tree.TreeData;
import com.isoftstone.agiledev.hrdemo.report.web.vo.User;

@Controller
@RequestMapping
public class QueryController {
	
	@RequestMapping
    public QueryResult<User> list(QueryParameters para){

		User u1 = new User(1,"zhangsan",22,"gd","huawei");
		User u2 = new User(2,"lisi",23,"hk","iss");
		User u3 = new User(3,"wangwu",24,"hn","huawei");
		User u4 = new User(4,"liuyi",25,"sc","huawei");
		User u5 = new User(5,"ss",25,"df","iss");
		User u11 = new User(1,"zhangsan",22,"gd","huawei");
		User u21 = new User(2,"lisi",23,"hk","iss");
		User u31 = new User(3,"wangwu",24,"hn","huawei");
		User u41 = new User(4,"liuyi",25,"sc","huawei");
		User u51 = new User(5,"kaka",26,"yn","iss");
		User u12 = new User(1,"zhangsan",22,"gd","huawei");
		User u22 = new User(2,"lisi",23,"hk","iss");
		User u32 = new User(3,"wangwu",24,"hn","huawei");
		User u42 = new User(4,"liuyi",25,"sc","huawei");
		User u52 = new User(5,"kaka",26,"yn","iss");
		
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
		
		QueryResult<User> users = new QueryResult<User>(15,list);
		return users;
    }
	@RequestMapping
	public TreeData getmenu(){
		Node n1 = new Node("1","节点1",true);
		
		Node n11 = new Node("11","节点1.1",false,"test.html");
		Node n12 = new Node("12","节点1.2",false,"test.html");
		n1.addChild(n11);
		n1.addChild(n12);
		
		List<Node> nodes = new ArrayList<Node>();
		nodes.add(n1);
		
		
		TreeData d = new TreeData(nodes);
		return d;
	}
}
