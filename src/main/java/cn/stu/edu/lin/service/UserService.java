package cn.stu.edu.lin.service;

import cn.stu.edu.lin.model.User;

public interface UserService {
	public User getUserById(int userId);

	public boolean checkUser(int userId, String password);

	public int updateUserInfo(User record);

	public int insertUser(User record);

}