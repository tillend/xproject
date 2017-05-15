package cn.stu.edu.lin.model.log;

/**
 * 数据访问的类型 比如：db, redis, http
 */
public enum DataAccessType {
	MYSQL("MySQL"), REDIS("Redis"), HTTP("Http");

	private String value;

	private DataAccessType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
