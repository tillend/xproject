package cn.stu.edu.lin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.stu.edu.lin.dao.RoomMapper;
import cn.stu.edu.lin.model.Room;
import cn.stu.edu.lin.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService {
	@Autowired
	private RoomMapper roomDao;

	@Override
	public Room getRoom(int roomNum) {
		return roomDao.selectByPrimaryKey(roomNum);
	}

	@Override
	public int insertRoom(int anchorId) {
		Room record = new Room();
		record.setAnchorid(anchorId);
		return roomDao.insertSelective(record);
	}

	@Override
	public Room getRoomByAnchorId(int anchorId) {
		return roomDao.selectByAnchorId(anchorId);
	}

	@Override
	public int updateRoomInfo(Room record) {
		return roomDao.updateByPrimaryKeySelective(record);
	}

}
