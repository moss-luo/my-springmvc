package com.kingkewow.springmvc.biz;

import java.util.List;

import com.kingkewow.springmvc.model.UserModel;

public interface UserService {
	public List<UserModel> queryUser() throws Exception;
}
