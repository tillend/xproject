package cn.stu.edu.lin.interceptor;

import cn.sut.edu.lin.annotation.IgnoreLogin;
import cn.sut.edu.lin.annotation.Multipart;

public class AuthSessionAnnotation {

	private final boolean isIgnoreLogin;
	private final boolean isMultipart;

	public AuthSessionAnnotation(IgnoreLogin ignoreLogin, Multipart multipart) {
		this.isIgnoreLogin = (ignoreLogin != null);
		this.isMultipart = (multipart != null);
	}

	public boolean isIgnoreLogin() {
		return isIgnoreLogin;
	}

	public boolean isMultipart() {
		return isMultipart;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(40);
		builder.append("[isIgnoreLogin=");
		builder.append(isIgnoreLogin);
		builder.append(", isMultipart=");
		builder.append(isMultipart);
		builder.append("]");
		return builder.toString();
	}
}
