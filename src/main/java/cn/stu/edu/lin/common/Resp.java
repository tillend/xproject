package cn.stu.edu.lin.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.alibaba.fastjson.annotation.JSONField;

public class Resp {

	/**
	 * 响应状态码
	 */
	private final int code;

	/**
	 * 响应描述信息
	 */
	private final String msg;

	/**
	 * 业务响应代码
	 */
	private final String subCode;

	/**
	 * 业务响应描述
	 */
	private final String subMsg;

	/**
	 * 响应数据
	 */
	private final Object data;

	public Resp(RespCode code, String subCode, String subMsg, Object data) {
		this.code = code.getCode();
		this.msg = code.getMsg();
		this.subCode = subCode;
		this.subMsg = subMsg;
		this.data = data;
	}

	public static ResponseEntity<Resp> createSuccess(Object data) {
		return create(RespCode.SUCCESS, null, null, data);
	}

	public static ResponseEntity<Resp> createError(RespCode code, String subCode, String subMsg) {
		return create(code, subCode, subMsg, null);
	}

	public static ResponseEntity<Resp> create(RespCode code, String subCode, String subMsg, Object data) {
		Resp resp = new Resp(code, subCode, subMsg, data);
		return new ResponseEntity<Resp>(resp, HttpStatus.OK);
	}

	@JSONField(name = "code")
	public int getCode() {
		return code;
	}

	@JSONField(name = "msg")
	public String getMsg() {
		return msg;
	}

	@JSONField(name = "sub_code")
	public String getSubCode() {
		return subCode;
	}

	@JSONField(name = "sub_msg")
	public String getSubMsg() {
		return subMsg;
	}

	public Object getData() {
		return data;
	}
}
