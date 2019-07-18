package com.zy.service;

import com.zy.bean.User;
import com.zy.dao.UserDao;

public class UserService {

	private UserDao userDao=new UserDao();
	
	public int addUser(User user) {
		return userDao.addUser(user);
	}
	
	public User queryUser(String username,String password) {
		return userDao.queryUser(username, password);
	}
	
}
