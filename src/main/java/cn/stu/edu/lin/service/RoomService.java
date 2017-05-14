package cn.stu.edu.lin.service;

import cn.stu.edu.lin.model.Room;

public interface RoomService {

	public Room getRoom(int roomNum);

	public Room getRoomByAnchorId(int achorId);

	public int insertRoom(int anchorId);

	public int updateRoomInfo(Room record);

}
