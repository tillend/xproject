package cn.stu.edu.lin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.sut.edu.lin.annotation.IgnoreLogin;

@Controller
@RequestMapping("/")
public class UrlController {

	@IgnoreLogin
	@RequestMapping("/index")
	public String toIndex() {
		return "index";
	}

	@IgnoreLogin
	@RequestMapping("/login")
	public String toLogin() {
		return "login";
	}

	@IgnoreLogin
	@RequestMapping("/sign_up")
	public String toSignUp() {
		return "sign_up";
	}

	@IgnoreLogin
	@RequestMapping("/play")
	public String toPlay() {
		return "play";
	}

	@IgnoreLogin
	@RequestMapping("/star")
	public String toStar() {
		return "star";
	}
}
