package cn.stu.edu.lin.model.log;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

public abstract class AbstractLogBean {
	// 日志类型
	@JSONField(serialize = false)
	private String eventName;
	// 日志中的非结构化数据部分，主要目的是便于人工阅读
	@JSONField(serialize = false)
	private String msg = "OK";

	// 日志规范中的json字段，用来统计使用。注：此字段中的key的数据类型必须固定，比如：userId为long，则以后所有的值都为long，不能再值String等
	@JSONField(serialize = false)
	private Map<String, Object> json = new HashMap<>();

	// 协议：http, osp
	private String protocol;
	// 请求参数
	@JSONField(name = "request_param")
	private Object request;
	// 响应参数
	@JSONField(name = "result")
	private Object response;
	// 返回码，0代表成功
	@JSONField(name = "ret_code")
	private String returnCode = "0";
	// 调用的开始
	@JSONField(name = "start_time_ms")
	private long startTime;
	// 响应时长，单位：ms
	@JSONField(name = "resp_time_ms")
	private long responseTime;
	// 异常
	@JSONField(serialize = false)
	private Exception e;
	// 请求的调用链ID
	@JSONField(name = "trace_id")
	private String traceId;

	public AbstractLogBean() {

	}

	public AbstractLogBean(String eventName, String protocol) {
		this.startTime = System.currentTimeMillis();
		this.eventName = eventName;
		this.protocol = protocol;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public Object getRequest() {
		return request;
	}

	public void setRequest(Object request) {
		this.request = request;
	}

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public long getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(long responseTime) {
		this.responseTime = responseTime;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Exception getE() {
		return e;
	}

	public void setE(Exception e) {
		this.e = e;
	}

	public String getTraceId() {
		return traceId;
	}

	public void setTraceId(String traceId) {
		this.traceId = traceId;
	}

	// 向json中添加一个参数，用来统计使用
	public void addJsonParam(String key, Object value) {
		json.put(key, value);
	}

	@Override
	public String toString() {
		responseTime = System.currentTimeMillis() - startTime;

		StringBuilder sb = new StringBuilder();
		sb.append("[").append(getEventName());
		if (StringUtils.isNotBlank(getReturnCode())) {
			sb.append("_").append(getReturnCode());
		}
		sb.append("]");
		sb.append(" json=").append(JSON.toJSONString(json));
		sb.append(" msg=").append(JSON.toJSONString(this)).append(" ").append(msg);

		return sb.toString();
	}
}
