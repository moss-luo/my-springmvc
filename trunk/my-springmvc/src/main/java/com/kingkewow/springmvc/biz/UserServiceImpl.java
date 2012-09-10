package com.kingkewow.springmvc.biz;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kingkewow.springmvc.dao.CommonDao;
import com.kingkewow.springmvc.model.UserModel;
@Service
@SuppressWarnings("unchecked")
public class UserServiceImpl implements UserService{
	@Autowired
	private CommonDao dbDao;
	@Override
	public List<UserModel> queryUser() throws Exception {
		List<UserModel> list = new ArrayList<UserModel>();
		try{
			list = (List<UserModel>) dbDao.selectList("com.kingkewow.springmvc.dao.UserMapper.queryUser", null);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	public void setDbDao(CommonDao dbDao) {
		this.dbDao = dbDao;
	}
	public CommonDao getDbDao() {
		return dbDao;
	}
	
}
