package com.isoftstone.agiledev.hrdemo.ligerui.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.isoftstone.agiledev.core.tree.Node;
import com.isoftstone.agiledev.core.tree.TreeData;
import com.isoftstone.agiledev.core.tree.TreeDataProvider;
import com.isoftstone.agiledev.hrdemo.workbench.app.IMenuManager;
import com.isoftstone.agiledev.hrdemo.workbench.app.Menu;

@Controller
public class MenuBarController implements TreeDataProvider {
	private List<Node> nodes;
	
	@Resource
	private IMenuManager menuManager;
	
	@RequestMapping
	public TreeData getligerui(@RequestParam(value="id", required=false) String id) {
		return new TreeData(getNodes(id));
	}
	
	public List<Node> getNodes(String parentId) {
		List<Node> nodes = convertToNodes(menuManager.getMenus(parentId));
		for(Node n:nodes){
			if(n.hasChild()){
				List<Node> childs = getNodes(n.getId());
				n.setChildren(childs);
			}
		}
		return nodes;
	}
	
	private List<Node> convertToNodes(List<Menu> menus) {
		List<Node> nodes = new ArrayList<Node>();
		if (menus == null || menus.size() == 0)
			return nodes;
		
		for (Menu menu : menus) {
			Node node = new Node(menu.getId(), menu.getText());
			node.setUrl(menu.getAction());
			node.setHasChild(menu.getHasChild());
			
			nodes.add(node);
		}
		
		return nodes;
	}

	public List<Node> getNodes() {
		return nodes;
	}
}
