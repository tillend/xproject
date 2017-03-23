package cn.stu.edu.lin.dao;

import cn.stu.edu.lin.model.RoomSign;

public interface RoomSignMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RoomSign record);

    int insertSelective(RoomSign record);

    RoomSign selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoomSign record);

    int updateByPrimaryKey(RoomSign record);
}