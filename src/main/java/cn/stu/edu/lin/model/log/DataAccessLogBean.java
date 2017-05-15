package cn.stu.edu.lin.model.log;

import com.alibaba.fastjson.annotation.JSONField;

public class DataAccessLogBean extends AbstractLogBean {
	@JSONField(name = "svc_name")
	private String ospServiceName;

	@JSONField(name = "method_name")
	private String ospMethodName;
	// 系统访问的数据类型
	private DataAccessType dataAccessType;
	// 访问缓存时使用的命令
	private String command;
	// HTTP请求时的URL
	private String url;

	public DataAccessLogBean() {
		super();
	}

	public DataAccessLogBean(String eventName, String protocol) {
		super("dataaccess_" + eventName, protocol);
	}

	/**
	 * 构造访问Mysql服务时的LogBean
	 */
	public static DataAccessLogBean newDataAccessMysqlLogBean() {
		DataAccessLogBean logBean = new DataAccessLogBean(DataAccessType.MYSQL.getValue(), "TCP");
		logBean.setDataAccessType(DataAccessType.MYSQL);

		return logBean;
	}

	public static DataAccessLogBean newDataAccessRedisLogBean() {
		DataAccessLogBean logBean = new DataAccessLogBean(DataAccessType.REDIS.getValue(), "TCP");
		logBean.setDataAccessType(DataAccessType.REDIS);

		return logBean;
	}

	/**
	 * 构造访问Redis服务时的LogBean
	 */
	public static DataAccessLogBean newDataAccessRedisLogBean(String command) {
		DataAccessLogBean logBean = new DataAccessLogBean(DataAccessType.REDIS.getValue(), "TCP");
		logBean.setDataAccessType(DataAccessType.REDIS);
		logBean.setCommand(command);

		return logBean;
	}

	public static DataAccessLogBean newDataAccessHttpLogBean() {
		DataAccessLogBean logBean = new DataAccessLogBean(DataAccessType.HTTP.getValue(), "HTTP");
		logBean.setDataAccessType(DataAccessType.HTTP);

		return logBean;
	}

	public static DataAccessLogBean newDataAccessHttpLogBean(String url) {
		DataAccessLogBean logBean = new DataAccessLogBean(DataAccessType.HTTP.getValue(), "HTTP");
		logBean.setDataAccessType(DataAccessType.HTTP);
		logBean.setUrl(url);

		return logBean;
	}

	public DataAccessType getDataAccessType() {
		return dataAccessType;
	}

	public void setDataAccessType(DataAccessType dataAccessType) {
		this.dataAccessType = dataAccessType;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
