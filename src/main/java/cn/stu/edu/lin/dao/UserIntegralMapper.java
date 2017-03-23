package cn.stu.edu.lin.dao;

import cn.stu.edu.lin.model.UserIntegral;

public interface UserIntegralMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserIntegral record);

    int insertSelective(UserIntegral record);

    UserIntegral selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserIntegral record);

    int updateByPrimaryKey(UserIntegral record);
}