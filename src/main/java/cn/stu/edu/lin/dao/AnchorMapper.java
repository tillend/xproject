package cn.stu.edu.lin.dao;

import cn.stu.edu.lin.model.Anchor;

public interface AnchorMapper {
    int deleteByPrimaryKey(Integer anchorid);

    int insert(Anchor record);

    int insertSelective(Anchor record);

    Anchor selectByPrimaryKey(Integer anchorid);

    int updateByPrimaryKeySelective(Anchor record);

    int updateByPrimaryKey(Anchor record);
}