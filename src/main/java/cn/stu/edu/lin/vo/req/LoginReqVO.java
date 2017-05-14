package cn.stu.edu.lin.vo.req;

import java.io.Serializable;

public class LoginReqVO implements Serializable {

	private static final long serialVersionUID = -1912047702407310420L;

	private Integer userid;
	private String password;

	public Integer getUserId() {
		return userid;
	}

	public void setUserId(Integer userId) {
		this.userid = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
