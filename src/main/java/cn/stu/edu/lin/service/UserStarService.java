package cn.stu.edu.lin.service;

import java.util.List;

import cn.stu.edu.lin.model.UserStar;

public interface UserStarService {

	public List<UserStar> getUserAllStar(int userId);

	public int updateUserStar(UserStar userStar);

}
