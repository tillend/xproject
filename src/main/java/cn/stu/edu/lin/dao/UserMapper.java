package cn.stu.edu.lin.dao;

import org.springframework.stereotype.Repository;

import cn.stu.edu.lin.model.User;

@Repository
public interface UserMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);
}