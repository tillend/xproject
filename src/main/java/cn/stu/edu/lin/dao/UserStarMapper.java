package cn.stu.edu.lin.dao;

import java.util.List;

import cn.stu.edu.lin.model.UserStar;

public interface UserStarMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(UserStar record);

	int insertSelective(UserStar record);

	UserStar selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(UserStar record);

	int updateByPrimaryKey(UserStar record);

	List<UserStar> queryAllStar(int userId);
}