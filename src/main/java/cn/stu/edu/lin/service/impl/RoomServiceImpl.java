package cn.stu.edu.lin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import cn.stu.edu.lin.dao.RoomMapper;
import cn.stu.edu.lin.model.Room;
import cn.stu.edu.lin.service.RoomService;

public class RoomServiceImpl implements RoomService {
	@Autowired
	private RoomMapper roomDao;

	@Override
	public Room getRoom(int roomNum) {
		return roomDao.selectByPrimaryKey(roomNum);
	}

}
