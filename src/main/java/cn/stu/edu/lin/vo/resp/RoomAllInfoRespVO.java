package cn.stu.edu.lin.vo.resp;

public class RoomAllInfoRespVO {
	private Integer roomnum;

	private Integer anchorid;

	private String roomname;

	private String roommessage;

	private Integer usercount;

	private String type;

	private String status;

	private String sign1;

	private String sign2;

	private String sign3;

	private String anchorname;

	private String level;

	private String integral;

	public Integer getRoomnum() {
		return roomnum;
	}

	public void setRoomnum(Integer roomnum) {
		this.roomnum = roomnum;
	}

	public Integer getAnchorid() {
		return anchorid;
	}

	public void setAnchorid(Integer anchorid) {
		this.anchorid = anchorid;
	}

	public String getRoomname() {
		return roomname;
	}

	public void setRoomname(String roomname) {
		this.roomname = roomname == null ? null : roomname.trim();
	}

	public String getRoommessage() {
		return roommessage;
	}

	public void setRoommessage(String roommessage) {
		this.roommessage = roommessage == null ? null : roommessage.trim();
	}

	public Integer getUsercount() {
		return usercount;
	}

	public void setUsercount(Integer usercount) {
		this.usercount = usercount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}

	public String getSign1() {
		return sign1;
	}

	public void setSign1(String sign1) {
		this.sign1 = sign1 == null ? null : sign1.trim();
	}

	public String getSign2() {
		return sign2;
	}

	public void setSign2(String sign2) {
		this.sign2 = sign2 == null ? null : sign2.trim();
	}

	public String getSign3() {
		return sign3;
	}

	public void setSign3(String sign3) {
		this.sign3 = sign3 == null ? null : sign3.trim();
	}

	public String getAnchorname() {
		return anchorname;
	}

	public void setAnchorname(String anchorname) {
		this.anchorname = anchorname;
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

}