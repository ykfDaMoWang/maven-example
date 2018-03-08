package com.web.service;

import java.util.List;

import com.web.entity.User;

public interface IUserService {

	public User getUserById(int id);
	
	public List<User> getAllUser();
	
	public void addListUserAuto(List<User> list);
	
	public void addListUser(List<User> list);
	
	public void addUser(User user);
	
	public void deleteUserById(int id);
	
	public void deleteListUser(List<User> list);
	
	public void updateUserById(User user);
	
	public void updateListUser(List<User> list);
	
}
