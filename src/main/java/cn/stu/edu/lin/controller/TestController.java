package cn.stu.edu.lin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.stu.edu.lin.model.User;
import cn.stu.edu.lin.service.IUserService;

@Controller
@RequestMapping("/user")
public class TestController {
	@Autowired
	private IUserService userService;

	@RequestMapping("/showUser")
	public String toIndex(HttpServletRequest request, Model model) {
		int userId = Integer.parseInt(request.getParameter("id"));
		User user = this.userService.getUserById(userId);
		model.addAttribute("user", user);
		return "showUser";
	}
}