package cn.stu.edu.lin.common;

/**
 * 响应代码
 */
public enum RespCode {

	/**
	 * 成功
	 */
	SUCCESS(0, "success"),

	/**
	 * 处理中
	 */
	PROCESSING(1, "processing"),

	/**
	 * 参数错误
	 */
	PARAM_ERR(400, "param_error"),

	/**
	 * 业务无效，需要使用 subCode, subMsg 进行区分
	 */
	BUSINESS_INVALID(402, "business_invalid"),

	/**
	 * 拒绝访问，需要使用 subCode, subMsg 进行区分
	 */
	ACCESS_DENIED(405, "access_denied"),

	/**
	 * 错误，需要使用 subCode, subMsg 进行区分
	 */
	ERROR(500, "error");
	private final int code;
	private final String msg;

	private RespCode(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
}
