package cn.stu.edu.lin.dao;

import cn.stu.edu.lin.model.UserPresent;

public interface UserPresentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserPresent record);

    int insertSelective(UserPresent record);

    UserPresent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserPresent record);

    int updateByPrimaryKey(UserPresent record);
}