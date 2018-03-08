package com.web.mapper;

import java.util.List;

import com.web.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	void insertListUser(List<User> list);

	void insertListUserAuto(List<User> list);

	List<User> selectAllUser();

	void deleteListUser(List<User> list);

	void updateListUser(List<User> list);

	void insertUserAuto(User user);

}