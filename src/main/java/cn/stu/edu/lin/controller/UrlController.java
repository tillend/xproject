package cn.stu.edu.lin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UrlController {

	@RequestMapping("/index")
	public String toIndex(HttpServletRequest request, Model model) {
		// System.out.println("here");
		return "index";
	}
}
