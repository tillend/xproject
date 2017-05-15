package cn.stu.edu.lin.model.log;

import com.alibaba.fastjson.annotation.JSONField;

public class ServiceAccessLogBean extends AbstractLogBean {
	@JSONField(name = "user_id")
	private String userId;

	// 此clientIp不是指调用方的ip，而是客户的clientIp(客户浏览器端请求时的ip)
	@JSONField(name = "client_ip")
	private String clientIp;

	public ServiceAccessLogBean() {
		super();
	}

	public ServiceAccessLogBean(String eventName, String protocol, String userId, String clientIp) {
		super("serviceaccess_" + eventName, protocol);
		this.userId = userId;
		this.clientIp = clientIp;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}
}
