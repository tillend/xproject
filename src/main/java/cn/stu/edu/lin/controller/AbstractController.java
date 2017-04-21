package cn.stu.edu.lin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

public class AbstractController {

	@Autowired
	HttpServletRequest request;

}
