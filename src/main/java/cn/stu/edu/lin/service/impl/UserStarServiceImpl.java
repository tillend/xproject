package cn.stu.edu.lin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.stu.edu.lin.dao.UserStarMapper;
import cn.stu.edu.lin.model.UserStar;
import cn.stu.edu.lin.service.UserStarService;

@Service
public class UserStarServiceImpl implements UserStarService {
	@Autowired
	private UserStarMapper userStarDao;

	@Override
	public List<UserStar> getUserAllStar(int userId) {
		return userStarDao.queryAllStar(userId);
	}

	@Override
	public int updateUserStar(UserStar userStar) {
		return userStarDao.updateByPrimaryKeySelective(userStar);
	}

}
