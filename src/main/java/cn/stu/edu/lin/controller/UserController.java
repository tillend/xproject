package cn.stu.edu.lin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.stu.edu.lin.common.Resp;
import cn.stu.edu.lin.model.User;
import cn.stu.edu.lin.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	public ResponseEntity<Resp> getUser() {
		ResponseEntity<Resp> responseEntity = null;

		int userId = 1;
		User user = userService.getUserById(userId);

		responseEntity = Resp.createSuccess(user);

		return responseEntity;
	}
}