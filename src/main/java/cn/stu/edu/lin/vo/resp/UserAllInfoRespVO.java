package cn.stu.edu.lin.vo.resp;

import java.util.List;

import cn.stu.edu.lin.vo.RoomMsg;

public class UserAllInfoRespVO {

	private String account;

	private String username;

	private String phone;

	private String email;

	private String status;

	private Integer anchorid;

	private String level;

	private String integral;

	private List<RoomMsg> roomList;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getAnchorid() {
		return anchorid;
	}

	public void setAnchorid(Integer anchorid) {
		this.anchorid = anchorid;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getIntegral() {
		return integral;
	}

	public void setIntegral(String integral) {
		this.integral = integral;
	}

	public List<RoomMsg> getRoomList() {
		return roomList;
	}

	public void setRoomList(List<RoomMsg> roomList) {
		this.roomList = roomList;
	}

}
