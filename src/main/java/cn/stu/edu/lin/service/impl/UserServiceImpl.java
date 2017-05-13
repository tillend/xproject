package cn.stu.edu.lin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.stu.edu.lin.dao.UserMapper;
import cn.stu.edu.lin.model.User;
import cn.stu.edu.lin.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userDao;

	@Override
	public User getUserById(int userId) {
		return this.userDao.selectByPrimaryKey(userId);
	}

	@Override
	public boolean checkUser(int userId, String password) {
		User user = userDao.selectByPrimaryKey(userId);

		if (password.equals(user.getPassword())) {
			return true;
		}

		return false;
	}

	@Override
	public int updateUserInfo(User record) {
		return userDao.updateByPrimaryKey(record);
	}

}