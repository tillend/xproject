package cn.stu.edu.lin.dao;

import cn.stu.edu.lin.model.Room;

public interface RoomMapper {
	int deleteByPrimaryKey(Integer roomnum);

	int insert(Room record);

	int insertSelective(Room record);

	Room selectByPrimaryKey(Integer roomnum);

	Room selectByAnchorId(Integer anchorid);

	int updateByPrimaryKeySelective(Room record);

	int updateByPrimaryKey(Room record);
}