package cn.stu.edu.lin.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServletUtils {

	private static final Logger log = LoggerFactory.getLogger(ServletUtils.class);

	public static final int COOKIE_DEFAULT_EXPIRY = 60 * 60 * 24 * 7; // cookie默认保存时间为1周
	public static final int COOKIE_EXPIRY = 0; // cookie注销时间

	private ServletUtils() {

	}

	public static String getCookieValue(Cookie[] cookies, String name) {
		Cookie cookie = getCookie(cookies, name);
		if (cookie == null) {
			return null;
		}
		return cookie.getValue();
	}

	public static Cookie getCookie(Cookie[] cookies, String name) {
		if (ArrayUtils.isEmpty(cookies)) {
			return null;
		}
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(name)) {
				return cookie;
			}
		}
		return null;
	}

	public static void setCookie(HttpServletRequest request, HttpServletResponse response, String name, String value) {
		setCookie(request, response, name, value, COOKIE_DEFAULT_EXPIRY);
	}

	public static void deleteCookie(HttpServletRequest request, HttpServletResponse response, String name) {
		setCookie(request, response, name, null, COOKIE_EXPIRY);
	}

	public static void setCookie(HttpServletRequest request, HttpServletResponse response, String name, String value,
			int expiry) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(expiry);
		cookie.setPath(request.getContextPath()); // 默认保存路径在项目路径下,eg:/xproject
		response.addCookie(cookie);
	}

}