package cn.stu.edu.lin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.stu.edu.lin.dao.UserIntegralMapper;
import cn.stu.edu.lin.model.UserIntegral;
import cn.stu.edu.lin.service.UserIntegralService;

@Service
public class UserIntegralServiceImpl implements UserIntegralService {
	@Autowired
	private UserIntegralMapper userIntegralDao;

	@Override
	public UserIntegral getUserIntegral(int userId) {
		return userIntegralDao.selectByPrimaryKey(userId);
	}

}
