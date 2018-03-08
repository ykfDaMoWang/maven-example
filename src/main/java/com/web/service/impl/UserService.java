package com.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.web.entity.User;
import com.web.mapper.UserMapper;
import com.web.service.IUserService;

@Service
public class UserService implements IUserService{

	@Resource
	private UserMapper userMapper;
	
	
	@Override
	@Cacheable(value="myCache", key="'user:' + #Id")
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return this.userMapper.selectByPrimaryKey(id);
	}

	@Override
	public void addListUser(List<User> list) {//批量插入用户
		// TODO Auto-generated method stub
		this.userMapper.insertListUser(list);
	}

	@Override
	public void addListUserAuto(List<User> list) {
		// TODO Auto-generated method stub
		this.userMapper.insertListUserAuto(list);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return this.userMapper.selectAllUser();
	}

	@Override
	public void deleteUserById(int id) {
		// TODO Auto-generated method stub
		this.userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void deleteListUser(List<User> list) {
		// TODO Auto-generated method stub
		this.userMapper.deleteListUser(list);
	}

	@Override
	@CacheEvict(value="myCache",key="'user:' + #Id")
	public void updateUserById(User user) {
		// TODO Auto-generated method stub
		this.userMapper.updateByPrimaryKey(user);
	}

	@Override
	public void updateListUser(List<User> list) {
		// TODO Auto-generated method stub
		this.userMapper.updateListUser(list);
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
	    this.userMapper.insertUserAuto(user);
	}
	
	
}
