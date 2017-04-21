package cn.stu.edu.lin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UrlController {

	@RequestMapping("/index")
	public String toIndex() {
		return "index";
	}

	@RequestMapping("/loginPage")
	public String toLogin() {
		return "login";
	}

	@RequestMapping("/sign_up")
	public String toSignUp() {
		return "sign_up";
	}

	@RequestMapping("/play")
	public String toPlay() {
		return "play";
	}

	@RequestMapping("/star")
	public String toStar() {
		return "star";
	}
}
