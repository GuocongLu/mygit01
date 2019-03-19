package com.lgc.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.lgc.mapper.UserMapper;
import com.lgc.pojo.User;


@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper userMapper;

	@Override
	public User findByName(String name) {
		return userMapper.findByName(name);
	}

}
