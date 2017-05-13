package cn.stu.edu.lin.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import cn.stu.edu.lin.util.ServletUtils;

public class AbstractController {

	@Autowired
	HttpServletRequest request;

	protected int getUserId() {
		Cookie[] cookies = request.getCookies();
		String userId = ServletUtils.getCookieValue(cookies, "uid");
		return Integer.parseInt(userId);

	}

}
