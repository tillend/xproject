package cn.stu.edu.lin.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.stu.edu.lin.dao.UserMapper;
import cn.stu.edu.lin.model.User;
import cn.stu.edu.lin.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	@Resource
	private UserMapper userDao;

	@Override
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return this.userDao.selectByPrimaryKey(userId);
	}

}