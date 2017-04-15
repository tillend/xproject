package cn.stu.edu.lin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UrlController {

	@RequestMapping("/index")
	public String toIndex() {
		// System.out.println("here");
		return "index";
	}

	@RequestMapping("/player")
	public String toPlayer() {
		// System.out.println("here");
		return "player";
	}

	@RequestMapping("/play")
	public String toPlay() {
		// System.out.println("here");
		return "play";
	}

	@RequestMapping("/star")
	public String toStar() {
		// System.out.println("here");
		return "star";
	}
}
